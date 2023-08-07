package com.empik.interview.app;

import com.empik.interview.Greeting;
import com.empik.interview.app.logic.Result;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class MyWebClient {

    private final WebClient client;

    public MyWebClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    public Mono<String> getMessage() {
        return this.client.get().uri("/users/aaa").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Result.class)
                .map(Result::login)
                ;
    }

}