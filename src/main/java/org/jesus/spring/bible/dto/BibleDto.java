package org.jesus.spring.bible.dto;


import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BibleDto {
    private String index;
    private Integer chapter;
    private Integer number;
    private String text;
}
