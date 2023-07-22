package com.empik.interview.app.logic;

import com.empik.interview.app.collector.GitUser;
import org.springframework.stereotype.Component;

@Component
public class ResultFactory {
    public Result create(GitUser u) {
        return new Result(
                String.valueOf(u.getId()),
                u.getLogin(),
                u.getName(),
                u.getType(),
                u.getAvatar_url(),
                u.getCreated_at().toString(),
                calculationLogic(u).toString()
        );
    }

    static Double calculationLogic(GitUser u) {
        return 6d * (2 + u.getPublic_repos()) / u.getFollowers();
    }
}
