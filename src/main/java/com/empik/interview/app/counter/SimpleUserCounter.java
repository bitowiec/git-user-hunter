package com.empik.interview.app.counter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ConditionalOnMissingBean(DataSource.class)
public class SimpleUserCounter implements UserCounter<Audit> {
    private final Map<String, Integer> cache = new ConcurrentHashMap<>();

    @Override
    public Audit findByLogin(String login) {
        Integer count = cache.getOrDefault(login, 0);
        return new Audit(login, count.longValue());
    }

    @Override
    public Integer makeItCount(String login) {
        return cache.merge(login, 1, Integer::sum);
    }
}
