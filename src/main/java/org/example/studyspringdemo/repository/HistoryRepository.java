/**
 * 进行数据库交流-定义数据库操作方法与sql语句
 */

package org.example.studyspringdemo.repository;

import jakarta.transaction.Transactional;
import org.example.studyspringdemo.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, String> {
    List<History> findAllById(String id);

    // 自定义删除方法，根据userId删除记录
    @Modifying
    @Transactional
    @Query("DELETE FROM history History WHERE History.id = :id")
    void deleteById(@Param("id") String id);
}