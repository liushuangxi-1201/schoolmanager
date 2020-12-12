package cn.kgc.service;

import cn.kgc.entity.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseSelectService {
    /**
     * 查询所有系部
     * @return
     */
    List<Department> findAll();

    /**
     * 根据系部id查询该系部下所有专业
     * @param did
     * @return
     */
    List<Major> findByDid(Integer did);

    /**
     * 根据专业id查询该专业下所有年级
     * @param mid
     * @return
     */
    List<Grade> findByMid(Integer mid);

    /**
     * 根据年级id查询该年级下所有班级
     * @param gid
     * @return
     */
    List<Classinfo> findByGid(Integer gid);

    /**
     * 根据班级id查询该班级下所有学生
     * @param cid
     * @return
     */
    List<Student> findByCid(Integer cid);

    /**
     * 根据下拉框的值查询
     * 该查询涉及分页查询(采用技术：pagehelper)
     * @param did 系部id
     * @param mid 专业id
     * @param gid 年级id
     * @param classid 班级id
     * @return
     */
    PageInfo<CourseSelect> findAllBySelect(Integer did, Integer mid,
                                     Integer gid, Integer classid, String sname,
                                     Integer pageIndex,Integer pageSize);
    /**
     * 查询开设课程表通过系部id
     * @param mid 系部id
     * @return
     */
    List<Course> findCourseByMid(Integer mid);
    /**
     * 修改学生所选课程
     *
     * @param cid
     * @param scid
     * @param oldCid 老的课程id
     * @return
     */
    Integer update(Integer cid,Integer scid,Integer oldCid);

    /**
     * 删除学生所选课程（逻辑删除）
     * @param scid
     * @param oldCid 老的课程id
     * @return
     */
    Integer del(Integer scid,Integer oldCid);
}
