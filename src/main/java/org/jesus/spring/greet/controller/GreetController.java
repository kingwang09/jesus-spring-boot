package org.jesus.spring.greet.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.greet.entity.Greet;
import org.jesus.spring.greet.model.GreetDto;
import org.jesus.spring.greet.service.GreetService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/greet")
public class GreetController {
    private final GreetService greetService;

    @GetMapping
    public GreetDto hello(@RequestParam String name, @RequestParam(required = false, defaultValue = "hello world!") String message){
        log.debug("hello name={}, message={}", name, message);
        return GreetDto.builder()
                .name(name)
                .message(message)
                .build();
    }

    @PostMapping
    public GreetDto save(@RequestBody GreetDto greetDto){
        log.debug("save greet: {}", greetDto);
        Greet greet = greetService.save(greetDto);
        log.debug("save {}", greet);
        return greet.toDto();
    }
}
