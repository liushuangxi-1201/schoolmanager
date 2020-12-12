package cn.kgc.service;

import cn.kgc.entity.Classinfo;
import cn.kgc.mapper.ClassinfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassinfoServiceImpl implements ClassinfoService {
    @Autowired
    private ClassinfoMapper classinfoMapper;


    @Override
    public PageInfo<Classinfo> findAll(Integer did, Integer mid, Integer gid, Integer classid, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo pageInfo = new PageInfo(classinfoMapper.findAll(did, mid, gid, classid));
        return pageInfo;
    }

    @Override
    public List<Classinfo> findAllSel() {
        return classinfoMapper.findAll(null,null,null,null);
    }

    @Override
    public Integer add(Classinfo classinfo) {
        return classinfoMapper.add(classinfo);
    }

    @Override
    public Integer update(Classinfo classinfo) {
        return classinfoMapper.update(classinfo);
    }

    @Override
    public Integer updateClassNum(Integer classid) {
        return classinfoMapper.updateClassNum(classid);
    }

}
