package com.empik.interview.app.collector;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toMap;

@Service
@ConditionalOnBean(UserCollector.class)
public class PredefinedUserCollector implements UserCollector {
    private final GitUser user;

    public PredefinedUserCollector(ObjectMapper objectMapper) {
        File f = new File("src/main/resources/static/octocat-response.json");
        try {
            user = objectMapper.readValue(f, GitUser.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GitUser collect(String login) {
        return user;
    }
}
