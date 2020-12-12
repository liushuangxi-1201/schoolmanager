package cn.kgc.service;

import cn.kgc.entity.Grade;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GradeService {
    /**
     * 查询
     * @param gid
     * @param mid
     * @param did
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<Grade> findAll(Integer gid, Integer mid, Integer did, Integer pageIndex, Integer pageSize);
    /**
     * 查询所有(下拉列表)
     * @return
     */
    List<Grade> findAllSel();

    /**
     * 添加年级
     * @param grade
     * @return
     */
    Integer add(Grade grade);

    /**
     * 修改年级
     * @param grade
     * @return
     */
    Integer update(Grade grade);
    /**
     * 根据班级id修改年级人数
     * @param classid
     * @return
     */
    Integer updateGradeNum(Integer classid);
}
