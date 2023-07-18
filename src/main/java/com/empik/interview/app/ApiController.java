package com.empik.interview.app;

import com.empik.interview.app.collector.UserCollector;
import com.empik.interview.app.collector.GitUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {
    public static final String API_PATH = "/users";

    private final UserCollector collector;

    @GetMapping(API_PATH + "/{login}")
    public String fetchLogin(@PathVariable String login) {
        GitUser user = collector.collect(login);

        Integer id = user.id();
        return id.toString();
    }
}
