package com.empik.interview.app.logic;

public record Result(
        String id,
        String login,
        String name,
        String type,
        String avatarUrl,
        String createdAt,
        String calculations
) {
}
