package com.leicht.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leicht.spring.domain.Journal;

public interface JournalRepository  extends JpaRepository<Journal, Long>{

}
