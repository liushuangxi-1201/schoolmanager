package cn.kgc.controller;

import cn.kgc.entity.*;
import cn.kgc.service.CourseSelectService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 选课管理视图层
 */
@Controller
@RequestMapping("/csel")
public class CourseSelectController {
    @Autowired
    private CourseSelectService courseSelectService;

    @RequestMapping("/toSelCourseMan")
    public String toSelCourseMan() {
        return "SelCourseMan";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public String findAll() {
        List<Department> departments = courseSelectService.findAll();
        return JSONArray.toJSONString(departments);
    }

    @ResponseBody
    @RequestMapping("/findByDid")
    public String findByDid(Integer did) {
        List<Major> majors = courseSelectService.findByDid(did);
        return JSONArray.toJSONString(majors);
    }

    @ResponseBody
    @RequestMapping("/findByMid")
    public String findByMid(Integer mid) {
        List<Grade> grades = courseSelectService.findByMid(mid);
        return JSONArray.toJSONString(grades);
    }

    @ResponseBody
    @RequestMapping("/findByGid")
    public String findByGid(Integer gid) {
        List<Classinfo> classinfos = courseSelectService.findByGid(gid);
        return JSONArray.toJSONString(classinfos);
    }

    @ResponseBody
    @RequestMapping("/findByCid")
    public String findByCid(Integer cid) {
        List<Student> students = courseSelectService.findByCid(cid);
        return JSONArray.toJSONString(students);
    }

    @ResponseBody
    @RequestMapping("/findAllBySelect")
    private String findAllBySelect(@RequestParam(value = "did", required = false, defaultValue = "-1") Integer did,
                                   @RequestParam(value = "mid", required = false, defaultValue = "-1") Integer mid,
                                   @RequestParam(value = "gid", required = false, defaultValue = "-1") Integer gid,
                                   @RequestParam(value = "classid", required = false, defaultValue = "-1") Integer classid,
                                   @RequestParam(value = "sname", required = false, defaultValue = "") String sname,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "limit", required = false, defaultValue = "10") Integer pageSize) {
        PageInfo<CourseSelect> pageInfo = courseSelectService.findAllBySelect(did, mid, gid, classid, sname, pageIndex, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return JSON.toJSONString(map);
    }

    @ResponseBody
    @RequestMapping("findCourseByMid")
    public String findCourseByMid(Integer mid) {
        List<Course> courses = courseSelectService.findCourseByMid(mid);
        return JSON.toJSONString(courses);
    }
    @ResponseBody
    @RequestMapping("update")
    public String update(Integer cid,Integer scid,Integer oldCid) {
        Integer row=courseSelectService.update(cid, scid,oldCid);
        if (row > 0) {
            return "更改课程成功!!!";
        } else if (row == 0) {
            return "更改课程失败!!!";
        } else {
            return "该课程已选人数充足，请在挑挑其他课程!!!";
        }
    }

    @ResponseBody
    @RequestMapping("del")
    public String del(Integer scid,Integer oldCid) {
        Integer row = courseSelectService.del(scid, oldCid);
        if (row != 0) {
            return "强制退课成功!!!";
        }
        return "强制退课失败!!!";
    }

}
