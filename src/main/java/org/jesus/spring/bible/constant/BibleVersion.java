package org.jesus.spring.bible.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BibleVersion{
    KING_JAMES("킹제임스"),
    NIV("NIV"),
    KOREAN("개역 한글"),
    KOREAN_IMPROVE("개역 개정"),
    KOREAN_STANDARD("표준 새번역"),
    KOREAN_CURRENT("현대인의 성경");

    private String description;
}