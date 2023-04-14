package org.jesus.spring.bible.repository;

import org.jesus.spring.bible.entity.Bible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibleRepository extends JpaRepository<Bible, Long> {
}
