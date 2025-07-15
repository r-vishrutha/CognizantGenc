package com.week4.spring_learn.service;

import com.week4.spring_learn.Country;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Service                         // makes it a Spring bean
public class CountryService {

    public Country getCountry(String code) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("country.xml");

        @SuppressWarnings("unchecked")
        List<Country> list = (List<Country>) ctx.getBean("countryList");

        return list.stream()                         // Java 8 lambda
                   .filter(c -> c.getCode().equalsIgnoreCase(code))
                   .findFirst()
                   .orElseThrow(() ->
                         new IllegalArgumentException("Invalid country code: " + code));
    }
}
