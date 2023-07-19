package com.empik.interview.app.collector;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
@ConditionalOnProperty(prefix = "github.app", name = "connection.enabled", havingValue = "true")
public class GitHubUserCollector implements UserCollector {

    private final RestTemplate restTemplate;

    public GitHubUserCollector(RestTemplateBuilder b) {
        this.restTemplate = b.build();
    }
    @Override
    public GitUser collect(String login) {
        return this.restTemplate.getForObject("https://api.github.com/users/" + login, GitUser.class);
    }
}
