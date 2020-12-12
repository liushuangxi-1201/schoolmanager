package cn.kgc.mapper;

import cn.kgc.entity.Classinfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClassinfoMapper {
    /**
     * 查询所有数据
     * @param did 部门id
     * @param mid 专业id
     * @param gid 年级id
     * @param classid 班级id
     * @return
     */
    List<Classinfo> findAll(Integer did,Integer mid,Integer gid,Integer classid);

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
