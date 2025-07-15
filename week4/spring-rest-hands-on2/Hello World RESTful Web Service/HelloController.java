package com.week4.spring_learn.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
public class HelloController {
	private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.debug("START — sayHello()");
        String response = "Hello World!!";
        LOGGER.debug("END   — sayHello()");
        return response;
}
