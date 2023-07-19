package com.empik.interview.app.collector;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
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
