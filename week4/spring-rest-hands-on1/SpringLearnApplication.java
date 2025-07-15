package com.week4.spring_learn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  
public class SpringLearnApplication {

    private static final Logger log =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        log.info(">>> Starting Spring‑Learn application...");
        SpringApplication.run(SpringLearnApplication.class, args);
        log.info(">>> Spring‑Learn started successfully.");
    }
}