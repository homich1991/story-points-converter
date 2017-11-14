package com.epam.springclouddemo.developer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeepThoughtCaller {

    @Autowired
    private DeepThoughtClient deepThoughtClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public Integer getStoryPoints(int hours) {
        return deepThoughtClient.convert(hours);
    }

    private Integer fallback(int hours) {
        return 42;
    }

}