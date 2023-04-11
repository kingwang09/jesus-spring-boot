package org.jesus.spring.greet.webflux;

import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.greet.model.GreetDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class GreetingHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        log.debug("reactive hello!!");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(
                        GreetDto.builder()
                                .name("hello")
                                .message("world!!")
                        .build()
                ));
    }
}
