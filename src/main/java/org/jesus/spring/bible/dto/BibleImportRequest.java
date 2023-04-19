package org.jesus.spring.bible.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jesus.spring.bible.constant.BibleVersion;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BibleImportRequest {

    private String path;
    private BibleVersion translationVersion;
}
