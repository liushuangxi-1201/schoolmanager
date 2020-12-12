package cn.kgc.controller;

import cn.kgc.service.ScheduleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("getAllSchedule")
    @ResponseBody
    public Object getAllSchedule() {
        Map<String, Object> newsList = new HashMap<String, Object>();
        newsList.put("code", 0);
        newsList.put("msg", "");
        newsList.put("count", 1000);
        newsList.put("data", scheduleService.getAllSchedule());
        return JSON.toJSONString(newsList);
    }
}
