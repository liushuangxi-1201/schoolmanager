package cn.kgc.service;

import cn.kgc.entity.Classinfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClassinfoService {
    /**
     * 查询所有数据
     *
     * @param did     部门id
     * @param mid     专业id
     * @param gid     年级id
     * @param classid 班级id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<Classinfo> findAll(Integer did, Integer mid, Integer gid, Integer classid, Integer pageIndex, Integer pageSize);

    /**
     * 下拉列表
     * @return
     */
    List<Classinfo> findAllSel();


    /**
     * 添加班级表
     * @param classinfo
     * @return
     */
    Integer add(Classinfo classinfo);

    /**
     * 修改班级表
     * @param classinfo
     * @return
     */
    Integer update(Classinfo classinfo);
    /**
     * 根据班级id修改班级人数
     * @param classid
     * @return
     */
    Integer updateClassNum(Integer classid);
}
