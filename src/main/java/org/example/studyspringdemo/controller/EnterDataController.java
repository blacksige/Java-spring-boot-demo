package org.example.studyspringdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.example.studyspringdemo.OTD.EnterDataOtd;
import org.example.studyspringdemo.config.IpUtil;
import org.example.studyspringdemo.model.EnterData;
import org.example.studyspringdemo.service.EnterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/nodeapp/enterData")
public class EnterDataController {

    @Autowired
    private EnterDataService enterDataService;

    @GetMapping(value = "/getAllData")
    public List<EnterData> getAllData(HttpServletRequest request) {
        String id = IpUtil.getClientIp(request);
        System.out.println(id);
        return enterDataService.getEnterDataById(id);
    }

    @PostMapping(value = "/setAllData")
    public void setAllData(@RequestBody EnterDataOtd enterDataOtd, HttpServletRequest request) {
        EnterData enterData = new EnterData();
        String id = IpUtil.getClientIp(request);

        enterData.setId(id);
        enterData.setTextarea(enterDataOtd.getTextarea());
        enterDataService.updateEnterData(enterData);
    }

    @PostMapping(value = "/deleteData")
    public void deleteData(HttpServletRequest request) {
        String id = IpUtil.getClientIp(request);
        enterDataService.deleteEnterData(id);
    }
}
