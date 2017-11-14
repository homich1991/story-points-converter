package com.epam.springclouddemo.sender;

import com.epam.springclouddemo.receiver.DeepThought;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("deep-thought")
public interface DeepThoughtFeign extends DeepThought {
}
