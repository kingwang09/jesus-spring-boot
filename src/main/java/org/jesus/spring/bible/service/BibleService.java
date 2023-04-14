package org.jesus.spring.bible.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BibleService {

    private final BibleImportService bibleImportService;


}
