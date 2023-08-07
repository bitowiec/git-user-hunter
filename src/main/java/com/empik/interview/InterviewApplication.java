package com.empik.interview;

import com.empik.interview.app.MyWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableR2dbcRepositories
public class InterviewApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(InterviewApplication.class, args);
        MyWebClient client = context.getBean(MyWebClient.class);
        // We need to block for the content here or the JVM might exit before the message is logged
        System.out.println(">> message = " + client.getMessage().block());
    }
}
