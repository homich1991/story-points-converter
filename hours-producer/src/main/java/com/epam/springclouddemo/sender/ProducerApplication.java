package com.epam.springclouddemo.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@RestController
public class ProducerApplication {

    @GetMapping("/getTime")
    public Integer getTime() {
        int hours = generateTime();
        System.out.println("I think it would take " + hours + "hours");
        Integer receivedValue = restTemplate.getForObject("http://localhost:8081/convert/" + hours, Integer.class);
        System.out.println("Lead said it is " + receivedValue + " story points");
        return receivedValue;
    }

    private int generateTime() {
        return time[new Random().nextInt(time.length)];
    }

    private final int[] time = {1, 2, 4, 8, 16, 80};

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
