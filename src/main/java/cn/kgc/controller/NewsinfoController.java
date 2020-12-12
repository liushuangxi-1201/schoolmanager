package cn.kgc.controller;

import cn.kgc.entity.Newsinfo;
import cn.kgc.service.NewsinfoService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("newsinfo")
public class NewsinfoController {

    @Autowired
    private NewsinfoService newsinfoService;

    @ResponseBody
    @RequestMapping("getAllNewsinfo")
    public Object getAllNewsinfo(Integer pageNum,Integer pageSize) {
        Map<String, Object> newsList1 = new HashMap<String, Object>();
        PageInfo<Newsinfo> pageInfo=newsinfoService.getAllNewsinfo(pageNum,5);
        //这是layui要求返回的json数据格式
        newsList1.put("pages", pageInfo.getPages());
        //将分页后的数据返回（每页要显示的数据）
        newsList1.put("data", pageInfo.getList());
        return newsList1;
    }
}
