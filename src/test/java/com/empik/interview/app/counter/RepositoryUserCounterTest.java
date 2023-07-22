package com.empik.interview.app.counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        properties = {"github-user-hunter.collector.search-path=src/main/resources/static/"}
)
class RepositoryUserCounterTest {
    public static final String LOGIN = "SillyName";
    @Autowired
    RepositoryUserCounter counter;

    @BeforeEach
    void setUp() {
        counter.deleteAll();
    }

    @Test
    void shouldBeNotExistingWhenLoginNotRequested() {
        assertThat(counter.existsByLoginLikeIgnoreCase(LOGIN)).isFalse();
    }
    @Test
    void shouldBeEqualOneWhenLoginRequestedOnce() {
        counter.makeItCount(LOGIN);
        assertThat(counter.existsByLoginLikeIgnoreCase(LOGIN)).isTrue();
        assertThat(counter.findByLogin(LOGIN).getCount()).isEqualTo(1L);
    }
    @Test
    void shouldBeEqualTwoWhenLoginRequestedTwice() {
        counter.makeItCount(LOGIN);
        counter.makeItCount(LOGIN);
        assertThat(counter.existsByLoginLikeIgnoreCase(LOGIN)).isTrue();
        assertThat(counter.findByLogin(LOGIN).getCount()).isEqualTo(2L);
    }
}