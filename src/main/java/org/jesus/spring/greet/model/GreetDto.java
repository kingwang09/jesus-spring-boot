package org.jesus.spring.greet.model;

import lombok.*;
import org.jesus.spring.greet.entity.Greet;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GreetDto {
    private String name;
    private String message;

    public Greet toEntity(){
        return Greet.builder()
                .name(this.name)
                .message(this.message)
                .build();
    }
}
