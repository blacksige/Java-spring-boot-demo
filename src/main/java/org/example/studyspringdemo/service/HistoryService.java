/**
 * service-调用数据仓库方法
 */

package org.example.studyspringdemo.service;

import org.example.studyspringdemo.model.History;
import org.example.studyspringdemo.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getHistoryById(String id) {
        return historyRepository.findAllById(id);
    }

    public void saveHistory(History history) {
        historyRepository.save(history);
    }

    public void deleteHistory(String id) {
        historyRepository.deleteById(id);
    }
}
