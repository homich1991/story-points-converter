package com.epam.developer;

import com.epam.deepthought.DeepThought;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("deep-thought")
public interface DeepThoughtClient extends DeepThought{
}
