package com.empik.interview.app.logic;

import com.empik.interview.app.collector.GitUser;
import org.assertj.core.api.AbstractDoubleAssert;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultFactoryTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Starting point", GitUser.builder().public_repos(0).followers(0).build(),
                        (Consumer<AbstractDoubleAssert<?>>) AbstractDoubleAssert::isInfinite),
                Arguments.of("Codding around", GitUser.builder().public_repos(3).followers(1).build(),
                        (Consumer<AbstractDoubleAssert<?>>) (AbstractDoubleAssert<?> a) -> a.isEqualTo(30d)),
                Arguments.of("Codestar", GitUser.builder().public_repos(10).followers(101).build(),
                        (Consumer<AbstractDoubleAssert<?>>) (AbstractDoubleAssert<?> a) -> a.isCloseTo(0.712, Percentage.withPercentage(1)))
        );
    }

    @ParameterizedTest(name = "[{index}]: {0}")
    @MethodSource("testCases")
    void shouldDoTheMath(String testCase, GitUser u, Consumer<AbstractDoubleAssert<?>> assertion) {
        assertion.accept(assertThat(ResultFactory.calculationLogic(u)));
    }
}