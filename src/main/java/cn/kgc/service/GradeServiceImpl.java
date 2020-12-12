package cn.kgc.service;

import cn.kgc.entity.Grade;
import cn.kgc.mapper.GradeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public PageInfo<Grade> findAll(Integer gid, Integer mid, Integer did, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo pageInfo = new PageInfo(gradeMapper.findAll(gid, mid, did));
        return pageInfo;
    }

    @Override
    public List<Grade> findAllSel() {
        return gradeMapper.findAllSel();
    }

    @Override
    public Integer add(Grade grade) {
        return gradeMapper.add(grade);
    }

    @Override
    public Integer update(Grade grade) {
        return gradeMapper.update(grade);
    }

    @Override
    public Integer updateGradeNum(Integer classid) {
        return gradeMapper.updateGradeNum(classid);
    }

}
