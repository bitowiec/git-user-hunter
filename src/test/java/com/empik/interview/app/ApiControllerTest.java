package com.empik.interview.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Map;

import static com.empik.interview.app.ApiController.API_PATH;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"github-user-hunter.collector.search-path=src/main/resources/static/"}
)
class ApiControllerTest {
    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void apiShouldBeExposed() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + API_PATH + "/octocat",
                Map.class))
                .containsEntry("id", "583231")
                .containsEntry("login", "octocat");
    }
}