package com.empik.interview.app.counter;

public interface UserCounter<T> {
    T findByLogin(String login);
    <S extends T> Integer makeItCount(String login);
}