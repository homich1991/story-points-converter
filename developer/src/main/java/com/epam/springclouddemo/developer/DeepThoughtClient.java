package com.epam.springclouddemo.developer;

import com.epam.springclouddemo.deepthought.DeepThought;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("deep-thought")
public interface DeepThoughtClient extends DeepThought{
}
