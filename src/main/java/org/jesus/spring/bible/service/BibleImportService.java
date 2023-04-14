package org.jesus.spring.bible.service;

import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.bible.entity.Bible;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class BibleImportService {

    private final String PATTERN_BIBLE = "([ㄱ-ㅎ가-힣])+|([\\d])+";
    public static final String BIBLE_INDEX_KEY = "bibleIndex";
    public static final String BIBLE_CHAPTER_KEY = "bibleChapter";
    public static final String BIBLE_LINE_KEY = "bibleLine";
    public static final String BIBLE_INDEX_VALUE = "bibleValue";

    public static final int BIBLE_INDEX = 0;
    public static final int BIBLE_CHAPTER = 1;
    public static final int BIBLE_LINE = 2;

    public Map<String, String> parsingLine(String line){
        Map<String, String> result = new HashMap<>();
        int index = line.indexOf(" ");
        String bibleIndex = line.substring(0, index);
        String bibleValue = line.substring(index + 1);

        Map<Integer, String> bibleIndexMap = parsingBibleIndexMap(bibleIndex);
        result.put(BIBLE_INDEX_KEY, bibleIndexMap.get(BIBLE_INDEX));
        result.put(BIBLE_CHAPTER_KEY, bibleIndexMap.get(BIBLE_CHAPTER));
        result.put(BIBLE_LINE_KEY, bibleIndexMap.get(BIBLE_LINE));
        result.put(BIBLE_INDEX_VALUE, bibleValue);
        return result;
    }

    public Bible parsingLine(String translationVersion, String line){
        Map<String, String> result = new HashMap<>();
        int index = line.indexOf(" ");
        String bibleRawIndex = line.substring(0, index);
        String bibleText = line.substring(index + 1);

        Map<Integer, String> bibleIndexMap = parsingBibleIndexMap(bibleRawIndex);
        String bibleIndex = bibleIndexMap.get(BIBLE_INDEX);
        Integer bibleChapter = Integer.valueOf(bibleIndexMap.get(BIBLE_CHAPTER));
        Integer bibleChapterNumber = Integer.valueOf(bibleIndexMap.get(BIBLE_LINE));

        return Bible.builder()
                .translationVersion(translationVersion)
                .bibleIndex(bibleIndex)
                .chapter(bibleChapter)
                .chapterNumber(bibleChapterNumber)
                .text(bibleText)
                .build();
    }

    private Map<Integer, String> parsingBibleIndexMap(String bibleIndexRaw){
        Map<Integer, String> result = new HashMap<>();
        int index = 0;
        Pattern p = Pattern.compile(PATTERN_BIBLE);    // 검색할 문자열 패턴
        Matcher m = p.matcher(bibleIndexRaw);            // 문자열 설정

        while (m.find()) {
            result.put(index, m.group());
            index++;
        }
        return result;
    }
}
