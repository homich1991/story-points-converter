package com.epam.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableCircuitBreaker
public class DeveloperApplication {

    @Autowired
    private DeepThoughtCaller deepThoughtCaller;

    @GetMapping("/estimation")
    public String getEstimation() {
        int hours = generateTime();

        System.out.println("I think it would take " + hours + " hours");

        Integer receivedValue = deepThoughtCaller.getStoryPoints(hours);

        String result = "Let it be " + receivedValue + " story points";
        System.out.println(result + "\n");

        return result;
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
