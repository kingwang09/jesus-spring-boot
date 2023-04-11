package org.jesus.spring.greet.repository;

import org.jesus.spring.greet.entity.Greet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetRepository extends JpaRepository<Greet, Long> {
}
