package com.epam.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class DeveloperApplication {

    @GetMapping("/getTime")
    public String getTime() {
        int hours = generateTime();

        System.out.println("I think it would take " + hours + " hours");

        Integer receivedValue = restTemplate.getForObject("http://deep-thought/convert/" + hours,
                Integer.class);

        String result = "Let it be " + receivedValue + " story points";
        System.out.println(result + "\n");

        return result;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //region Time generator
    private final int[] time = {1, 2, 4, 8, 16, 80};

    private int generateTime() {
        return time[new Random().nextInt(time.length)];
    }
    //endregion

    public static void main(String[] args) {
        SpringApplication.run(DeveloperApplication.class, args);
    }
}
