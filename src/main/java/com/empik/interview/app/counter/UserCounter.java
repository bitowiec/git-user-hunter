package com.empik.interview.app.counter;

public interface UserCounter<T> {
    <S extends T> Integer makeItCount(String login);
}