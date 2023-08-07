package com.empik.interview.app.counter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//import org.springframework.data.annotation.Id;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Audit {
//    @Id
//    @Id
//    @Column(name = "LOGIN", nullable = false)
    private String login;

//    @Column(name = "REQUEST_COUNT", nullable = false, columnDefinition = "BIGINT DEFAULT 0")
    private Long count;
}