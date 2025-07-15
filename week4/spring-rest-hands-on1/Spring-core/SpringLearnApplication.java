package com.week4.spring_learn;
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        displayCountry();                       // invoke immediately after Boot starts
    }

    private static void displayCountry() {
        LOGGER.debug("START — displayCountry()");
        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        ((ClassPathXmlApplicationContext) context).close(); // tidy‑up
        LOGGER.debug("END — displayCountry()");
    }
}