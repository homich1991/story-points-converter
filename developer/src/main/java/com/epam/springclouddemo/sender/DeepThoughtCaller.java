package com.epam.springclouddemo.sender;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeepThoughtCaller {

    @Autowired
    private DeepThoughtFeign deepThoughtFeign;

    @HystrixCommand(fallbackMethod = "fallback")
    public Integer getStoryPoints(int hours) {
        return deepThoughtFeign.convert(hours);
    }

    private Integer fallback(int hours) {
        return 42;
    }

}