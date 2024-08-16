/**
 * controller 处理前端请求并响应请求
 */

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
@RequestMapping(value = "/nodeapp/enterdata")
public class EnterDataController {

    @Autowired
    private EnterDataService enterDataService;

    @GetMapping(value = "/getAllData")
    public ApiResponse<List<EnterData>> getAllData(HttpServletRequest request) {
        String id = IpUtil.getClientIp(request);
        List<EnterData> enterDatas = enterDataService.getEnterDataById(id);
        return new  ApiResponse<>(200, "查询成功！", enterDatas);
    }

    @PostMapping(value = "/setAllData")
    public ApiResponse<Void> setAllData(@RequestBody EnterDataOtd enterDataOtd, HttpServletRequest request) {
        EnterData enterData = new EnterData();
        String id = IpUtil.getClientIp(request);

        enterData.setId(id);
        enterData.setTextarea(enterDataOtd.getTextarea());
        enterDataService.updateEnterData(enterData);
        return new ApiResponse<> (200, "保存成功！",null);
    }

    @PostMapping(value = "/deleteData")
    public ApiResponse<Void> deleteData(HttpServletRequest request) {
        String id = IpUtil.getClientIp(request);

        enterDataService.deleteEnterData(id);
        return new ApiResponse<> (200, "删除成功！",null);
    }
}



