package org.jesus.spring.greet.controller;

import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.greet.model.GreetDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/greet")
public class GreetController {

    @GetMapping
    public GreetDto hello(@RequestParam String name, @RequestParam(required = false, defaultValue = "hello world!") String message){
        log.debug("hello name={}, message={}", name, message);
        return GreetDto.builder()
                .name(name)
                .message(message)
                .build();
    }
}
