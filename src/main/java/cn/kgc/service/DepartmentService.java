package cn.kgc.service;

import cn.kgc.entity.Department;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DepartmentService {
    /**
     * 查询所有系部(分页查)
     * @param dname 系部名称
     * @return
     */
    PageInfo<Department> findAllByName(String dname, Integer pageIndex, Integer pageSize);

    /**
     * 系部管理的下拉列表的填值
     * (因为公用一个sql所以需要传参,该参数可以为空)
     * 公用sql为:
     * select * from department
     *         <if test="dname!=null and dname!=''">
     *             <where>
     *                 dname=#{dname}
     *             </where>
     *         </if>
     * 懂得自然懂
     * @return
     */
    List<Department> findAll(String dname);

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
