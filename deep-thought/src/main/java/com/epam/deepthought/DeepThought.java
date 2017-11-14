package com.epam.deepthought;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DeepThought {
    @GetMapping("/convert/{hours}")
    Integer convert(@PathVariable("hours") int hours);
}
