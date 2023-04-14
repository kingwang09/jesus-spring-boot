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

    public Map<Integer, String> parsingBibleIndexMap(String bibleIndexValue){
        Map<Integer, String> result = new HashMap<>();
        int index = 0;
        Pattern p = Pattern.compile("([ㄱ-ㅎ가-힣])+|([\\d])+");	// 검색할 문자열 패턴
        Matcher m = p.matcher(bibleIndexValue);			// 문자열 설정

        while (m.find()) {
            String value = m.group();
            log.debug("result: {}", value);
            result.put(index, value);
            index++;
        }
        return result;
    }
}
