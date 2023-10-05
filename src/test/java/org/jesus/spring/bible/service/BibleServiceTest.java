package org.jesus.spring.bible.service;

import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.bible.constant.BibleIndex;
import org.jesus.spring.bible.constant.BibleVersion;
import org.jesus.spring.bible.dto.BibleImportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@SpringBootTest
@ActiveProfiles("azure")
public class BibleServiceTest{

    @Autowired
    private BibleService bibleService;

    @Test
    public void importBibleTest() throws InterruptedException {
        BibleImportRequest request = BibleImportRequest.builder()
                .path("/Users/hyungeun.jin/file_import/translation_standard.txt")
                .translationVersion(BibleVersion.KOREAN_STANDARD)
                .build();
        bibleService.importBible(request);
    }

    @Test
    public void importEnglishBibleTest() throws InterruptedException {
        BibleImportRequest request = BibleImportRequest.builder()
                .path("/Users/hyungeun.jin/file_import/kjv.txt")
                .translationVersion(BibleVersion.KING_JAMES)
                .build();
        bibleService.importEnglishBible(request);
    }

    @Test
    public void migrationBibleIndex(){
        for(BibleIndex bibleIndex : BibleIndex.values()) {
            int bulkResult = bibleService.migrationUpdateBibleIndex(bibleIndex);
            log.debug("result: {}", bulkResult);
        }
    }
}
