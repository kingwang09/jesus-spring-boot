package org.jesus.spring.bible.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class FileImportServiceTest {

    @Test
    public void fileRead() throws IOException {
        //import할 파일 encoding이 UTF-8로 설정되어있어야함.
        Path path = Paths.get("/Users/test/file_import/translation.txt");
        List<String> lines = Files.readAllLines(path);
        int index = 0;
        for(String line : lines){
            if(index == 10){
                break;
            }
            log.debug("line: {}", line);
            index++;
        }
        log.debug("test end...");
    }
}
