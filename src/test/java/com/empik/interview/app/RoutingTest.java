package com.empik.interview.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

import static com.empik.interview.app.Routing.API_PATH;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"github-user-hunter.collector.search-path=src/main/resources/static/"}
)
class RoutingTest {

    @Autowired
    private WebTestClient webTestClient;

    /**
     * TODO Contract tests
     * https://spring.io/projects/spring-cloud-contract#overview
     * https://spring.io/blog/2018/02/13/spring-cloud-contract-in-a-polyglot-world
     * https://docs.spring.io/spring-cloud-contract/docs/current/reference/html/
     */
    @Test
    public void apiShouldBeExposed() {
        webTestClient.get().uri(API_PATH + "/octocat")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Map.class).value(r -> assertThat(r)
                        .containsEntry("id", "583231")
                        .containsEntry("login", "octocat")
                );
    }
}