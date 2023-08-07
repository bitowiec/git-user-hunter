package com.empik.interview.app.collector;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE        ,
        properties = {"github.app.connection.enabled=true"}
)
class ConnectivityGitHubUserCollectorTest {
    @Autowired
    private GitHubUserCollector collector;

//    @Test
    public void fetchingRealOcto() {
        assertThat(collector.collect("octocat"))
                .hasFieldOrProperty("id")
                .hasFieldOrProperty("login")
                .hasFieldOrProperty("name")
                .hasFieldOrProperty("type")
                .hasFieldOrProperty("avatar_url")
                .hasFieldOrProperty("created_at")
                .hasFieldOrProperty("public_repos")
                .hasFieldOrProperty("followers")
        ;
    }
}