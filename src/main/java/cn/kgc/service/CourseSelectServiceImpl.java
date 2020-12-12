package cn.kgc.service;

import cn.kgc.entity.*;
import cn.kgc.mapper.CourseSelectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CourseSelectServiceImpl implements CourseSelectService {
    @Autowired
    private CourseSelectMapper courseSelectMapper;

    @Override
    public List<Department> findAll() {
        return courseSelectMapper.findAll();
    }

    @Override
    public List<Major> findByDid(Integer did) {
        return courseSelectMapper.findByDid(did);
    }

    @Override
    public List<Grade> findByMid(Integer mid) {
        return courseSelectMapper.findByMid(mid);
    }

    @Override
    public List<Classinfo> findByGid(Integer gid) {
        return courseSelectMapper.findByGid(gid);
    }

    @Override
    public List<Student> findByCid(Integer cid) {
        return courseSelectMapper.findByCid(cid);
    }

    @Override
    public PageInfo<CourseSelect> findAllBySelect(Integer did, Integer mid,
                                            Integer gid, Integer classid, String sname,
                                            Integer pageIndex,Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<CourseSelect> pageInfo = new PageInfo<>(courseSelectMapper.findAllBySelect(did, mid, gid, classid, sname));
        return pageInfo;
    }

    @Override
    public List<Course> findCourseByMid(Integer mid) {
        return courseSelectMapper.findCourseByMid(mid);
    }

    @Override
    @Transactional//开启事务
    public Integer update(Integer cid, Integer scid,Integer oldCid) {
        Course course=courseSelectMapper.selCountAndMax(cid);
        if (course.getCselcount() >= course.getCmaxcount()) {//判断选课人数是否大于等于最大选课人数
            return -1;
        } else {
            System.out.println("老课程选课"+oldCid);System.out.println("新课程"+cid);
            courseSelectMapper.updateCountJian(oldCid);//老课程选课人数减一
            courseSelectMapper.updateCountJia(cid);//新课程id加一
            return courseSelectMapper.update(cid,scid);
        }
    }

    @Override
    @Transactional//开启事务
    public Integer del(Integer scid,Integer oldCid) {
        courseSelectMapper.updateCountJian(oldCid);//老课程选课人数减一
        return courseSelectMapper.del(scid);
    }

}
