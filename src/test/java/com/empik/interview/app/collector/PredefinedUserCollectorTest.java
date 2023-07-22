package com.empik.interview.app.collector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.Date;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PredefinedUserCollectorTest {

    public static final String PATH = "src/main/resources/static/";
    private final PredefinedUserCollector collector = new PredefinedUserCollector(PATH);

    private static Stream<String> testCases() {
        return Stream.of(
                "octocat",
                "bitowiec",
                "mariuszgil"
        );
    }

    @ParameterizedTest(name = "[{index}]: {0}")
    @MethodSource("testCases")
    void shouldFindUser(String login) {
        assertThat(collector.collect(login))
                .isNotNull()
                .hasFieldOrPropertyWithValue("login", login);
    }

    @Test
    void shouldParseAllValuesForParticularLogin() {
        GitUser collect = collector.collect("octocat");
        assertThat(collect)
                .hasFieldOrPropertyWithValue("login", "octocat")
                .hasFieldOrPropertyWithValue("id", 583231)
                .hasFieldOrPropertyWithValue("node_id", "MDQ6VXNlcjU4MzIzMQ==")
                .hasFieldOrPropertyWithValue("avatar_url", "https://avatars.githubusercontent.com/u/583231?v=4")
                .hasFieldOrPropertyWithValue("gravatar_id", "")
                .hasFieldOrPropertyWithValue("url", "https://api.github.com/users/octocat")
                .hasFieldOrPropertyWithValue("html_url", "https://github.com/octocat")
                .hasFieldOrPropertyWithValue("followers_url", "https://api.github.com/users/octocat/followers")
                .hasFieldOrPropertyWithValue("following_url", "https://api.github.com/users/octocat/following{/other_user}")
                .hasFieldOrPropertyWithValue("gists_url", "https://api.github.com/users/octocat/gists{/gist_id}")
                .hasFieldOrPropertyWithValue("starred_url", "https://api.github.com/users/octocat/starred{/owner}{/repo}")
                .hasFieldOrPropertyWithValue("subscriptions_url", "https://api.github.com/users/octocat/subscriptions")
                .hasFieldOrPropertyWithValue("organizations_url", "https://api.github.com/users/octocat/orgs")
                .hasFieldOrPropertyWithValue("repos_url", "https://api.github.com/users/octocat/repos")
                .hasFieldOrPropertyWithValue("events_url", "https://api.github.com/users/octocat/events{/privacy}")
                .hasFieldOrPropertyWithValue("received_events_url", "https://api.github.com/users/octocat/received_events")
                .hasFieldOrPropertyWithValue("type", "User")
                .hasFieldOrPropertyWithValue("site_admin", Boolean.FALSE.toString())
                .hasFieldOrPropertyWithValue("name", "The Octocat")
                .hasFieldOrPropertyWithValue("company", "@github")
                .hasFieldOrPropertyWithValue("blog", "https://github.blog")
                .hasFieldOrPropertyWithValue("location", "San Francisco")
                .hasFieldOrPropertyWithValue("email", null)
                .hasFieldOrPropertyWithValue("hireable", null)
                .hasFieldOrPropertyWithValue("bio", null)
                .hasFieldOrPropertyWithValue("twitter_username", null)
                .hasFieldOrPropertyWithValue("public_repos", 8)
                .hasFieldOrPropertyWithValue("public_gists", 8)
                .hasFieldOrPropertyWithValue("followers", 9811)
                .hasFieldOrPropertyWithValue("following", 9)
                .hasFieldOrPropertyWithValue("created_at", Date.from(Instant.parse("2011-01-25T18:44:36Z")))
                .hasFieldOrPropertyWithValue("updated_at", Date.from(Instant.parse("2023-06-22T11:15:59Z")));

    }
}