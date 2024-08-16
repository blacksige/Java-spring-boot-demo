/**
 * service-调用数据仓库方法
 */

package org.example.studyspringdemo.service;

import org.example.studyspringdemo.model.EnterData;
import org.example.studyspringdemo.repository.EnterDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterDataService {

    @Autowired
    private EnterDataRepository enterDataRepository;

    public List<EnterData> getEnterDataById(String id) {
        return enterDataRepository.findAllById(id);
    }

    public void updateEnterData(EnterData enterData) {
        enterDataRepository.save(enterData.getId(), enterData.getTextarea());
    }

    public void deleteEnterData(String id) {
        enterDataRepository.deleteById(id);
    }
}
