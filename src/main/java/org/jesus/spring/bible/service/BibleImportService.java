package org.jesus.spring.bible.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Map<String, String> parsingLines(String lines){
        Map<String, String> result = new HashMap<>();
        int index = lines.indexOf(" ");
        String bibleIndex = lines.substring(0, index);
        String bibleValue = lines.substring(index + 1);

        Map<Integer, String> bibleIndexMap = parsingBibleIndexMap(bibleIndex);
        result.put(BIBLE_INDEX_KEY, bibleIndexMap.get(BIBLE_INDEX));
        result.put(BIBLE_CHAPTER_KEY, bibleIndexMap.get(BIBLE_CHAPTER));
        result.put(BIBLE_LINE_KEY, bibleIndexMap.get(BIBLE_LINE));
        result.put(BIBLE_INDEX_VALUE, bibleValue);
        return result;
    }

    private Map<Integer, String> parsingBibleIndexMap(String bibleIndexValue){
        Map<Integer, String> result = new HashMap<>();
        int index = 0;
        Pattern p = Pattern.compile(PATTERN_BIBLE);	// 검색할 문자열 패턴
        Matcher m = p.matcher(bibleIndexValue);			// 문자열 설정

        while (m.find()) {
            result.put(index, m.group());
            index++;
        }
        return result;
    }
}
