package cn.kgc.service;

import cn.kgc.entity.Major;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MajorService {
    /**
     * 查询专业详情
     *
     * @param dname
     * @param mname
     * @return
     */
    PageInfo<Major> findByDnameAndMname(String dname, String mname, Integer pageIndex, Integer pageSize);

    /**
     * 查询下拉列表
     * @return
     */
    List<Major> findAll();
    /**
     * 添加专业
     * @param major
     * @return
     */
    Integer add(Major major);

    /**
     * 修改专业
     * @param major
     * @return
     */
    Integer update(Major major);
    /**
     * 根据班级id修改专业人数
     * @param classid
     * @return
     */
    Integer updateMajorNum(Integer classid);
}
