package org.jesus.spring.greet.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.greet.entity.Greet;
import org.jesus.spring.greet.model.GreetDto;
import org.jesus.spring.greet.repository.GreetRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GreetService {

    private final GreetRepository repository;

    public Greet save(GreetDto greetDto){
        return repository.save(greetDto.toEntity());
    }
}
