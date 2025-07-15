package com.week4.spring_learn.controller;

import com.week4.spring_learn.Country;
import com.week4.spring_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    
    private final CountryService countryService;

    @Autowired                      // constructor injection
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

  
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.debug("START — getCountry({})", code);
        Country country = countryService.getCountry(code);   // delegate to service
        LOGGER.debug("END   — getCountry({})", code);
        return country;                                      // Jackson → JSON
    }


    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.debug("START — getCountryIndia()");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        Country india = ctx.getBean("in", Country.class);
        LOGGER.debug("END   — getCountryIndia()");
        ((ClassPathXmlApplicationContext) ctx).close();
        return india;
    }


    @GetMapping("/countries")
    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
        LOGGER.debug("START — getAllCountries()");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        List<Country> list = (List<Country>) ctx.getBean("countryList");
        LOGGER.debug("END   — getAllCountries()");
        ((ClassPathXmlApplicationContext) ctx).close();
        return list;
    }
}
