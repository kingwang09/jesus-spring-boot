package org.jesus.spring.bible.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.bible.dto.BibleImportRequest;
import org.jesus.spring.bible.entity.Bible;
import org.jesus.spring.bible.repository.BibleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BibleService {

    private final BibleImportService bibleImportService;
    private final BibleRepository bibleRepository;


    @Transactional
    public Boolean importBible(BibleImportRequest request) throws InterruptedException {
        List<String> bibleLines = bibleImportService.readBibleFile(request.getPath());
        List<Bible> bibles = new LinkedList<>();
        for(String bibleLine : bibleLines) {
            Bible bible = bibleImportService.parsingLine(request.getTranslationVersion(), bibleLine);
            log.debug("bible: {}", bible);
            bibles.add(bible);
        }

        bibleRepository.saveAllAndFlush(bibles);

        return true;
    }
}
