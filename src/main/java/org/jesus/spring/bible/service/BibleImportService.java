package org.jesus.spring.bible.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class BibleImportService {

    private final String PATTERN_KOREAN = "^[ㄱ-ㅎ가-힣]*$";
    private final String PATTERN_NUMBER = "^[0-9]*$";

    public boolean isKorean(String value){
        return Pattern.matches(PATTERN_KOREAN, value);
    }

    public boolean isNumber(String value){
        return Pattern.matches(PATTERN_NUMBER, value);
    }

    public String parsingBibleIndex(String value){
        int index = value.indexOf(" ");
        String indexValue = value.substring(0, index);
        log.debug("index: {}", indexValue);
        return indexValue;
    }

    public Map<String, Object> parsingBibleIndexMap(String bibleIndex){
        char[] values = bibleIndex.toCharArray();
        for(int i = 0; i < values.length; i++){
            String value = String.valueOf(values[i]);

        }
        List<String> bibleIndexValues = bibleIndex.lines().collect(Collectors.toList());
        bibleIndexValues.forEach((v) -> {
            log.debug("v = {}", v);
        });
        return null;
    }
}
