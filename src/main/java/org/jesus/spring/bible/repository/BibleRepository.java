package org.jesus.spring.bible.repository;

import org.jesus.spring.bible.constant.BibleIndex;
import org.jesus.spring.bible.constant.BibleVersion;
import org.jesus.spring.bible.entity.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BibleRepository extends JpaRepository<Bible, Long> {

    @Query("select b from Bible b where b.translationVersion=:version and b.bibleIndex=:index")
    List<Bible> findAllByIndex(BibleVersion version, BibleIndex index);

    @Query("select b from Bible b where b.translationVersion=:version and b.bibleIndex=:index and b.chapter = :startChapter")
    List<Bible> findByIndexAndChapter(BibleVersion version,BibleIndex index, Integer startChapter);

    @Query("select b from Bible b where b.translationVersion=:version and b.bibleIndex=:index and b.chapter = :startChapter and b.chapterNumber = :number")
    List<Bible> findByIndexAndChapterAndNumber(BibleVersion version, BibleIndex index, Integer startChapter, Integer number);

    @Modifying(clearAutomatically = true)
    @Query("update Bible b set b.bibleIndex = :updateBibleIndex where b.bibleIndex=:searchBibleIndex")
    int bulkUpdateBibleIndex(String updateBibleIndex, String searchBibleIndex);
}
