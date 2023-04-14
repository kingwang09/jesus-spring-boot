package org.jesus.spring.bible.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
//@SpringBootTest
public class BibleImportServiceTest {

    @Test
    public void parsingBibleIndex(){
        String value = "삼상13:16";
        //Pattern p = Pattern.compile("([0-9])+");	// 검색할 문자열 패턴 : 숫자
        Pattern p = Pattern.compile("([ㄱ-ㅎ가-힣])+|([\\d])+");	// 검색할 문자열 패턴 : 숫자
        Matcher m = p.matcher(value);			// 문자열 설정

        while (m.find()) {
            log.debug("result: {}", m.group());
        }


        String value2 = "삼상13:16";
        //Pattern p = Pattern.compile("([0-9])+");	// 검색할 문자열 패턴 : 숫자
        Pattern p2 = Pattern.compile("([ㄱ-ㅎ가-힣])+");	// 검색할 문자열 패턴 : 숫자
        Matcher m2 = p2.matcher(value);			// 문자열 설정

        while (m2.find()) {
            log.debug("한글 result: {}", m2.group());
        }
    }
}
