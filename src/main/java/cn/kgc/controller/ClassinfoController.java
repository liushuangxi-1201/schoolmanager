package cn.kgc.controller;

import cn.kgc.entity.Classinfo;
import cn.kgc.entity.Grade;
import cn.kgc.service.ClassinfoService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cla")
public class ClassinfoController {
    @Autowired
    private ClassinfoService classinfoService;

    @GetMapping("/toClassmanage")
    public String toClassmanage() {
        return "/view/schoolmanage/classmanage";
    }

    @ResponseBody
    @RequestMapping("findAll")
    public String findAll(@RequestParam(value = "gid", required = false, defaultValue = "") Integer gid,
                          @RequestParam(value = "mid", required = false, defaultValue = "") Integer mid,
                          @RequestParam(value = "did", required = false, defaultValue = "") Integer did,
                          @RequestParam(value = "classid", required = false, defaultValue = "") Integer classid,
                          @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageIndex,
                          @RequestParam(value = "limit", required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<Classinfo> pageInfo = classinfoService.findAll(did, mid, gid, classid, pageIndex, pageSize);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return JSON.toJSONString(map);
    }
    @RequestMapping("/findAllSel")
    @ResponseBody
    public String findAllSel() {
        return JSON.toJSONString(classinfoService.findAllSel());
    }
    @RequestMapping("/add")
    @ResponseBody
    public Boolean add(Classinfo classinfo) {
        if (null == classinfo.getGid()) {
            return false;
        } else {
            Integer row = classinfoService.add(classinfo);
            if (row!=0) {
                return true;
            } else {
                return false;
            }
        }
    }
    @RequestMapping("/update")
    @ResponseBody
    public Boolean update(Classinfo classinfo) {
        Integer row = classinfoService.update(classinfo);
        if (row!=0) {
            return true;
        } else {
            return false;
        }
    }
}
