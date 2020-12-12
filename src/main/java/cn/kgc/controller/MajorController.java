package cn.kgc.controller;

import cn.kgc.entity.Major;
import cn.kgc.service.MajorService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/maj")
public class MajorController {
    @Autowired
    private MajorService majorService;
    @GetMapping("/toMajormanage")
    public String toMajormanage() {
        return "/view/schoolmanage/majormanage";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(value = "dname", required = false, defaultValue = "") String dname,
                          @RequestParam(value = "mname", required = false, defaultValue = "") String mname,
                          @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageIndex,
                          @RequestParam(value = "limit", required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<Major> pageInfo= majorService.findByDnameAndMname(dname, mname, pageIndex, pageSize);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return JSON.toJSONString(map);
    }

    @ResponseBody
    @RequestMapping("/findAllSel")
    public String findAllSel() {
        return JSON.toJSONString(majorService.findAll());
    }

    @ResponseBody
    @RequestMapping("/add")
    public Boolean add(Major major) {
        Integer row = majorService.add(major);
        if (row != 0) {
            return true;
        } else {
            return false;
        }
    }
    @ResponseBody
    @RequestMapping("/update")
    public Boolean update(Major major) {
        Integer row = majorService.update(major);
        if (row != 0) {
            return true;
        } else {
            return false;
        }
    }
}
