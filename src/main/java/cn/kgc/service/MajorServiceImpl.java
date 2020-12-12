package cn.kgc.service;

import cn.kgc.entity.Major;
import cn.kgc.mapper.MajorMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    @Override
    public PageInfo<Major> findByDnameAndMname(String dname, String mname, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo pageInfo = new PageInfo(majorMapper.findByDnameAndMname(dname, mname));
        return pageInfo;
    }

    @Override
    public List<Major> findAll() {
        return majorMapper.findByDnameAndMname("", "");
    }

    @Override
    public Integer add(Major major) {
        return majorMapper.add(major);
    }

    @Override
    public Integer update(Major major) {
        return majorMapper.update(major);
    }

    @Override
    public Integer updateMajorNum(Integer classid) {
        return majorMapper.updateMajorNum(classid);
    }

}
