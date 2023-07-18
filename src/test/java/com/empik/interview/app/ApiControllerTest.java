package com.empik.interview.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Map;

import static com.empik.interview.app.ApiController.API_PATH;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiControllerTest {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void apiShouldBeExposed() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + API_PATH + "/octo",
                String.class)).contains("login: octo");
    }

    @Test
    public void fetchingRealOcto() throws Exception {
        assertThat(this.restTemplate.getForObject("https://api.github.com/users/octocat",
                Map.class))
                .containsKey("id")
                .containsEntry("id", 58323111);
    }
}