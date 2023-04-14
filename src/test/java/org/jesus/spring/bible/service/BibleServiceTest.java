package org.jesus.spring.bible.service;

import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.bible.dto.BibleImportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@SpringBootTest
@ActiveProfiles("dev")
public class BibleServiceTest{

    @Autowired
    private BibleService bibleService;

    @Test
    public void importBibleTest() throws InterruptedException {
        BibleImportRequest request = BibleImportRequest.builder()
                .path("/Users/test/file_import/translation.txt")
                .translationVersion("개역개정")
                .build();
        bibleService.importBible(request);
    }
}
