package org.example.studyspringdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.studyspringdemo.OTD.HistoryOtd;
import org.example.studyspringdemo.config.IpUtil;
import org.example.studyspringdemo.model.History;
import org.example.studyspringdemo.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/nodeapp/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/getHistory")
    public List<History> getHistory(HttpServletRequest request) {
        String id = IpUtil.getClientIp(request);
        System.out.println(id);
        return historyService.getHistoryById(id);
    }

    @PostMapping(value = "/setHistory")
    public void setHistory(@RequestBody HistoryOtd historyOtd, HttpServletRequest request) {
        History history = new History();
        String id = IpUtil.getClientIp(request);

        history.setId(id);
        history.setDay(historyOtd.getDay());
        history.setName(historyOtd.getName());
        historyService.saveHistory(history);
    }

    @PostMapping(value = "/deleteData")
    public void deleteData(HttpServletRequest request) {
        String id = IpUtil.getClientIp(request);
        historyService.deleteHistory(id);
    }
}
