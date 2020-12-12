package cn.kgc.controller;

import cn.kgc.entity.Department;
import cn.kgc.service.DepartmentService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dep")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/toDpmmanage")
    public String toDpmmanage() {
        return "/view/schoolmanage/dpmmanage";
    }
    @ResponseBody
    @RequestMapping("/findAllByName")
    public String findAllByName(@RequestParam(value = "dname", required = false, defaultValue = "") String dname,
                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageIndex,
                                @RequestParam(value = "limit", required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageInfo pageInfo = departmentService.findAllByName(dname, pageIndex, pageSize);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return JSON.toJSONString(map);
    }

    /**
     * 查询下拉列表
     * @param dname 系部名称(前端可以不用传参!!!)
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(value = "dname", required = false, defaultValue = "") String dname) {
        List<Department> departments = departmentService.findAll(dname);
        return JSON.toJSONString(departments);
    }

    @ResponseBody
    @RequestMapping("/add")
    public Boolean add(Department department) {
        Integer row=departmentService.add(department);
        if (row != 0) {
            return true;
        } else {
            return false;
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Boolean update(Department department) {
        Integer row=departmentService.update(department);
        if (row != 0) {
            return true;
        } else {
            return false;
        }
    }
}
