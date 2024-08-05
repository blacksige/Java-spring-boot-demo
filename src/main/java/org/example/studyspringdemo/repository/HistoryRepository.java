package org.example.studyspringdemo.repository;

import org.example.studyspringdemo.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, String> {
    List<History> findAllById(String id);
}