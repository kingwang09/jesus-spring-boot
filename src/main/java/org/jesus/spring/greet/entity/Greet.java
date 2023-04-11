package org.jesus.spring.greet.entity;

import lombok.*;
import org.jesus.spring.greet.model.GreetDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Greet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String message;

    public GreetDto toDto(){
        return GreetDto.builder()
                .name(this.name)
                .message(this.message)
                .build();
    }
}
