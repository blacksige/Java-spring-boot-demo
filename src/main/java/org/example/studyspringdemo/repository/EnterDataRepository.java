package org.example.studyspringdemo.repository;

import jakarta.transaction.Transactional;
import org.example.studyspringdemo.model.EnterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterDataRepository extends JpaRepository<EnterData, String> {
    List<EnterData> findAllById(String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO enterdata (id, textarea) VALUES (:id, :textarea) " +
            "ON DUPLICATE KEY UPDATE textarea = :textarea", nativeQuery = true)
    void save(@Param("id") String id, @Param("textarea") String textarea);

    @Modifying
    @Transactional
    @Query("DELETE FROM enterdata EnterData WHERE EnterData.id =  :id")
    void deleteById(@Param("id") String id);

}
