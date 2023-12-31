package com.empik.interview.app.collector;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

@Service
public class PredefinedUserCollector implements UserCollector {
    public static final BiPredicate<Path, BasicFileAttributes> ONLY_FILES_PREDICATE = (path, attr) -> attr.isRegularFile();
    public static final Predicate<File> JSON_PREDICATE = f -> f.getAbsolutePath().endsWith(".json");
    public static final Collector<GitUser, ?, Map<String, GitUser>> COLLECTOR = collectingAndThen(
            toMap(GitUser::getLogin,
                    Function.identity(),
                    BinaryOperator.maxBy(Comparator.comparingInt(GitUser::getFollowers))),
            Collections::unmodifiableMap);
    private Map<String, GitUser> cache = Collections.EMPTY_MAP;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String searchPath;

    public PredefinedUserCollector(@Value(value = "${github-user-hunter.collector.search-path:src/main/resources/static/}") String searchPath) {
        this.searchPath = searchPath;
    }

    private Map<String, GitUser> collect() {
        try {
            Path path = Path.of(searchPath);
            return Files.find(path, 1, ONLY_FILES_PREDICATE)
                    .map(Path::toFile)
                    .filter(JSON_PREDICATE)
                    .map(this::getReadValue)
                    .collect(COLLECTOR);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private GitUser getReadValue(File f) {
        try {
            return objectMapper.readValue(f, GitUser.class);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + f, e);
        }
    }

    @Override
    public GitUser collect(String login) {
        if (cache.isEmpty()) {
            synchronized (cache) {
                if (cache.isEmpty()) {
                    cache = collect();
                }
            }
        }
        return cache.getOrDefault(login, cache.values().stream().findFirst().get());
    }
}
