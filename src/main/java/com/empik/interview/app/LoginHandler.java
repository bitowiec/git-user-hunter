package com.empik.interview.app;

import com.empik.interview.app.collector.GitUser;
import com.empik.interview.app.collector.UserCollector;
import com.empik.interview.app.counter.UserCounter;
import com.empik.interview.app.logic.Result;
import com.empik.interview.app.logic.ResultFactory;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class LoginHandler implements HandlerFunction<ServerResponse> {
    private final UserCounter counter;
    private final UserCollector collector;
    private final ResultFactory factory;

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        String login = request.pathVariable("login");

//        counter.makeItCount(login);
        GitUser user = collector.collect(login);
        Result result = factory.create(user);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(result));
    }
}
