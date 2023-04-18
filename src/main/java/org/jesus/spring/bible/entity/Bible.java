package org.jesus.spring.bible.entity;

import lombok.*;
import org.jesus.spring.bible.constant.BibleVersion;
import org.jesus.spring.bible.dto.BibleDto;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BibleVersion translationVersion;

//    @Enumerated(EnumType.STRING)
//    private BibleIndex bibleIndex;
    private String bibleIndex;

    private Integer chapter;

    private Integer chapterNumber;

    @Column(length = 4000)
    private String text;

    public BibleDto convert(){
        return BibleDto.builder()
                //.shortIndex(this.translationVersion == BibleVersion.KING_JAMES ? this.bibleIndex.getEnglishShortIndex() : this.bibleIndex.getKoreanShortIndex())
                .shortIndex(this.bibleIndex)
                .chapter(this.chapter)
                .number(this.chapterNumber)
                .text(this.text)
                .build();
    }
}
