package cn.kgc.controller;

import cn.kgc.entity.Grade;
import cn.kgc.service.GradeService;
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
@RequestMapping("/gra")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/toGrademanage")
    public String toGrademanage() {
        return "/view/schoolmanage/grademanage";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam(value = "gid", required = false, defaultValue = "") Integer gid,
                          @RequestParam(value = "mid", required = false, defaultValue = "") Integer mid,
                          @RequestParam(value = "did", required = false, defaultValue = "") Integer did,
                          @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageIndex,
                          @RequestParam(value = "limit", required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<Grade> pageInfo=gradeService.findAll(gid, mid, did, pageIndex, pageSize);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return JSON.toJSONString(map);
    }

    @RequestMapping("/findAllSel")
    @ResponseBody
    public String findAllSel() {
        return JSON.toJSONString(gradeService.findAllSel());
    }

    @RequestMapping("/add")
    @ResponseBody
    public Boolean add(Grade grade) {
        Integer row = gradeService.add(grade);
        if (row!=0) {
            return true;
        } else {
            return false;
        }
    }
    @RequestMapping("/update")
    @ResponseBody
    public Boolean update(Grade grade) {
        Integer row = gradeService.update(grade);
        if (row!=0) {
            return true;
        } else {
            return false;
        }
    }
}
