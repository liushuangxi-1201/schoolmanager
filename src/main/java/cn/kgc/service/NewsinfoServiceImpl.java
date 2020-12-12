package cn.kgc.service;

import cn.kgc.entity.Newsinfo;
import cn.kgc.mapper.NewsinfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsinfoServiceImpl implements NewsinfoService {

    @Autowired
    private NewsinfoMapper newsinfoMapper;

    @Override
    public PageInfo<Newsinfo> getAllNewsinfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Newsinfo> list=newsinfoMapper.getAllNewsinfo();
        PageInfo<Newsinfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
