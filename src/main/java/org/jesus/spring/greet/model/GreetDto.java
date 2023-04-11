package org.jesus.spring.greet.model;

import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GreetDto {
    private String name;
    private String message;
}
