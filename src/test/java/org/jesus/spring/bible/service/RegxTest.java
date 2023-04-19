package org.jesus.spring.bible.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RegxTest {

    @Test
    public void test(){
        String value = "1Sm13:16";
        Pattern p = Pattern.compile("[a-zA-Z]+|([\\d])+");    // 검색할 문자열 패턴 : 숫자
        Matcher m = p.matcher(value);            // 문자열 설정

        while (m.find()) {
            log.debug("result: {}", m.group());
        }


        String value2 = "Pet13:16";
        Matcher m2 = p.matcher(value2);            // 문자열 설정

        while (m2.find()) {
            log.debug("한글 result: {}", m2.group());
        }
    }

    @Test
    public void testMap(){
        Map<Integer, String> result = new HashMap<>();
        result.put(-1, "테스트");

        log.debug("result: {}", result);
    }
}
