package org.jesus.spring.bible.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.bible.constant.BibleIndex;
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
        int bulkCount = 1000;
        for(String bibleLine : bibleLines) {
            if(bibleLine == null || bibleLine.isBlank()){
                continue;
            }
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

    public Boolean importEnglishBible(BibleImportRequest request) throws InterruptedException {
        List<String> bibleLines = bibleImportService.readBibleFile(request.getPath());
        List<Bible> bibles = new LinkedList<>();
        int insertCount = 0;
        int bulkCount = 5000;
        for(String bibleLine : bibleLines) {
            if(bibleLine == null || bibleLine.isBlank()){
                continue;
            }
            Bible bible = bibleImportService.parsingLineByEnglish(request.getTranslationVersion(), bibleLine);
            log.debug("bible(english): {}", bible);
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
        BibleIndex shortBibleIndex = BibleIndex.findByKoreanShortIndex(index);
        if(number != null){
            return convert(bibleRepository.findByIndexAndChapterAndNumber(version, shortBibleIndex, start, number));
        }

        if(start != null){
            return convert(bibleRepository.findByIndexAndChapter(version, shortBibleIndex, start));
        }
        return convert(bibleRepository.findAllByIndex(version, shortBibleIndex));
    }

    private List<BibleDto> convert(List<Bible> bibles){
        return bibles.stream().map(Bible::convert).collect(Collectors.toList());
    }


    @Transactional
    public int migrationUpdateBibleIndex(BibleIndex bibleIndex){
        return bibleRepository.bulkUpdateBibleIndex(bibleIndex.toString(), bibleIndex.getKoreanShortIndex());
    }
}
