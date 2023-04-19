package org.jesus.spring.bible.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jesus.spring.bible.constant.BibleVersion;
import org.jesus.spring.bible.dto.BibleDto;
import org.jesus.spring.bible.service.BibleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/bible")
@RestController
public class BibleController {

    private final BibleService bibleService;


    @GetMapping
    public List<BibleDto> find(
            @RequestParam(required = false, defaultValue = "KOREAN") BibleVersion version,
            @RequestParam String index,
            @RequestParam(required = false) Integer chapter,
            @RequestParam(required = false) Integer number){
        return bibleService.find(version, index, chapter, number);
    }
}
