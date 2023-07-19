package com.empik.interview.app.counter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ConditionalOnMissingBean(DataSource.class)
public class SimpleUserCounter implements UserCounter<Audit> {
private final Map<String, Long> cache = new ConcurrentHashMap<>();

    public Audit save(Audit a) {
        String login = a.getLogin();
        Long result = cache.merge(login, 1L, Long::sum);
        return new Audit(login, result);
    }

    @Override
    public Integer makeItCount(String login) {
        //here value of counter doesn't matter cause value is kept in cache field
        save(new Audit(login, 0L));
        return 1;
    }
}
