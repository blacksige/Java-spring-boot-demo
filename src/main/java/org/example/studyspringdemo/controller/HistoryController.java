/**
 * controller 处理前端请求并响应请求
 */

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
    public  ApiResponse<List<History>> getHistory(HttpServletRequest request) {
        String id = IpUtil.getClientIp(request);
        System.out.println(id);
        List<History> historys = historyService.getHistoryById(id);
        return new  ApiResponse<>(200, "查询成功!", historys);
    }

    @PostMapping(value = "/setHistory")
    public ApiResponse<Void> setHistory(@RequestBody HistoryOtd historyOtd, HttpServletRequest request) {
        History history = new History();
        String id = IpUtil.getClientIp(request);

        history.setId(id);
        history.setDay(historyOtd.getDay());
        history.setName(historyOtd.getName());
        historyService.saveHistory(history);
        return new ApiResponse<> (200, "保存成功！",null);

    }

    @PostMapping(value = "/deleteData")
    public ApiResponse<Void> deleteData(HttpServletRequest request) {
        String id = IpUtil.getClientIp(request);
        historyService.deleteHistory(id);
        return new ApiResponse<> (200, "删除成功！",null);
    }
}

