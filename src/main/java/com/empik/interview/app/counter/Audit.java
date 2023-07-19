package com.empik.interview.app.counter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Audit {
    @Id
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "REQUEST_COUNT", nullable = false, columnDefinition = "BIGINT DEFAULT 0")
    private Long count;
}