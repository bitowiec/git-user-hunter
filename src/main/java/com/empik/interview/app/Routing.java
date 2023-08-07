package com.empik.interview.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


@Configuration(proxyBeanMethods = false)
public class Routing {
    public static final String API_PATH = "/users";
//todo https://spring.io/guides/gs/reactive-rest-service/
//todo https://docs.spring.io/spring-framework/reference/web/webflux-functional.html#webflux-fn-routes

    @Bean
    public RouterFunction<ServerResponse> route(LoginHandler loginHandler) {
        RequestPredicate requestPredicate = GET(API_PATH + "/{login}").and(accept(MediaType.APPLICATION_JSON));
        return RouterFunctions.route(requestPredicate, loginHandler::handle)
                ;
    }
}
