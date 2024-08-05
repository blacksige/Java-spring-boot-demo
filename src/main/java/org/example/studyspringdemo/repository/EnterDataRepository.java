package org.example.studyspringdemo.repository;

import org.example.studyspringdemo.model.EnterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterDataRepository extends JpaRepository<EnterData, String> {
    List<EnterData> findAllById(String id);
}
