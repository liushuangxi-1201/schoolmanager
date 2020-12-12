package cn.kgc.mapper;

import cn.kgc.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    /**
     * 查询所有系部
     * @param dname 系部名称
     * @return
     */
    List<Department> findAllByName(String dname);

    /**
     * 添加系部
     * @param department
     * @return
     */
    Integer add(Department department);

    /**
     * 修改系部
     * @param department
     * @return
     */
    Integer update(Department department);

    /**
     * 根据班级id修改系部人数
     * @param classid
     * @return
     */
    Integer updateDepartmentNum(Integer classid);
}
