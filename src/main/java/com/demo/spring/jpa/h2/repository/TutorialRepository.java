package com.demo.spring.jpa.h2.repository;

import java.util.List;

import com.demo.spring.jpa.h2.model.Tutorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContaining(String title);

  @Query("select p.id from #{#entityName} p")
  List<Long> getAllIds();
}
