package com.empik.interview.app;

import com.empik.interview.app.collector.GitUser;
import com.empik.interview.app.collector.UserCollector;
import com.empik.interview.app.counter.UserCounter;
import com.empik.interview.app.logic.Result;
import com.empik.interview.app.logic.ResultFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {
    public static final String API_PATH = "/users";

    private final UserCollector collector;
    private final ResultFactory factory;
    private final UserCounter counter;

    @GetMapping(API_PATH + "/{login}")
    public Result fetchLogin(@PathVariable String login) {
        counter.makeItCount(login);
        GitUser user = collector.collect(login);
        return factory.create(user);
    }
}
