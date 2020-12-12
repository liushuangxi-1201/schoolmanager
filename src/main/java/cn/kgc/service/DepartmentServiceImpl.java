package cn.kgc.service;

import cn.kgc.entity.Department;
import cn.kgc.mapper.DepartmentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public PageInfo<Department> findAllByName(String dname, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<Department> pageInfo = new PageInfo<>(departmentMapper.findAllByName(dname));
        return pageInfo;
    }

    @Override
    public List<Department> findAll(String dname) {
        return departmentMapper.findAllByName(dname);
    }

    @Override
    public Integer add(Department department) {
        return departmentMapper.add(department);
    }

    @Override
    public Integer update(Department department) {
        return departmentMapper.update(department);
    }

    @Override
    public Integer updateDepartmentNum(Integer classid) {
        return departmentMapper.updateDepartmentNum(classid);
    }

}
