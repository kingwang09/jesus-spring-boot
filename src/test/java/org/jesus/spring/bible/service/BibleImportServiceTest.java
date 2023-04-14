package org.jesus.spring.bible.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@SpringBootTest
public class BibleImportServiceTest {

    @Autowired
    private BibleImportService service;

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

    @Test
    public void parsingLines(){
        String[] tests = {
                "창1:1 태초에 하나님이 천지를 창조하시니라",
                "수10:24 그 왕들을 여호수아에게로 끌어내매 여호수아가 이스라엘 모든 사람을 부르고 자기와 함께 갔던 군장들에게 이르되 가까이 와서 이 왕들의 목을 발로 밟으라 가까이 와서 그들의 목을 밟으매",
                "시101:3 나는 비루한 것을 내 눈 앞에서 두지 아니할 것이요 배도자들의 행위를 미워하니 이것이 내게 붙접지 아니하리이다",
                "겔31:18 너의 영화와 광대함이 에덴 모든 나무 중에 어떤 것과 같은고 그러나 네가 에덴 나무와 함께 지하에 내려갈 것이요 거기서 할례받지 못하고 칼에 살륙당한 자 중에 누우리라 이들은 바로와 그 모든 군대니라 나 주 여호와의 말이니라 하라"
        };

        for(String line: tests){
            Map<String, String> result = service.parsingLine(line);
            log.debug("parsing result: {}", result);
        }
    }
}
