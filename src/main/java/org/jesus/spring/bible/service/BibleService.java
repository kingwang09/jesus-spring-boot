package org.jesus.spring.bible.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.bible.constant.BibleVersion;
import org.jesus.spring.bible.dto.BibleDto;
import org.jesus.spring.bible.dto.BibleImportRequest;
import org.jesus.spring.bible.entity.Bible;
import org.jesus.spring.bible.repository.BibleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class BibleService {

    private final BibleImportService bibleImportService;
    private final BibleRepository bibleRepository;


    public Boolean importBible(BibleImportRequest request) throws InterruptedException {
        List<String> bibleLines = bibleImportService.readBibleFile(request.getPath());
        List<Bible> bibles = new LinkedList<>();
        int insertCount = 0;
        int bulkCount = 100;
        for(String bibleLine : bibleLines) {
            Bible bible = bibleImportService.parsingLine(request.getTranslationVersion(), bibleLine);
            log.debug("bible: {}", bible);
            bibles.add(bible);

            if(insertCount == bulkCount){
                insert(bibles);
                bibles = new LinkedList<>();
                insertCount = 0;
            }
            insertCount++;
        }

        if(bibles.size() > 0){
            insert(bibles);
        }
        return true;
    }

    @Transactional
    public void insert(List<Bible> inserts){
        log.debug("insert: {}", inserts.size());
        bibleRepository.saveAllAndFlush(inserts);
    }

    public List<BibleDto> find(BibleVersion version, String index, Integer start, Integer number) {
        if(number != null){
            return convert(bibleRepository.findByIndexAndChapterAndNumber(version, index, start, number));
        }

        if(start != null){
            return convert(bibleRepository.findByIndexAndChapter(version, index, start));
        }
        return convert(bibleRepository.findAllByIndex(version, index));
    }

    private List<BibleDto> convert(List<Bible> bibles){
        return bibles.stream().map(Bible::convert).collect(Collectors.toList());
    }
}
