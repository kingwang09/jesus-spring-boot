package org.jesus.spring.bible.repository;

import org.jesus.spring.bible.entity.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BibleRepository extends JpaRepository<Bible, Long> {

    @Query("select b from Bible b where b.bibleIndex=:index")
    List<Bible> findAllByIndex(String index);

    @Query("select b from Bible b where b.bibleIndex=:index and b.chapter = :startChapter")
    List<Bible> findByIndexAndChapter(String index, Integer startChapter);

    @Query("select b from Bible b where b.bibleIndex=:index and b.chapter = :startChapter and b.chapterNumber = :number")
    List<Bible> findByIndexAndChapterAndNumber(String index, Integer startChapter, Integer number);
}
