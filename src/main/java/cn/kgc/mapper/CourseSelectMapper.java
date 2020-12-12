package cn.kgc.mapper;

import cn.kgc.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 选课管理接口，
 * 设计原因：
 *      选课管理涉及表过多，该接口将功能的表整合到一起，便于理解和阅读
 */
@Repository
public interface CourseSelectMapper {
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
     * @param classid
     * @return
     */
    List<Student> findByCid(Integer classid);

    /**
     * 根据下拉框的值查询
     * @param did 系部id
     * @param mid 专业id
     * @param gid 年级id
     * @param classid 班级id
     * @return
     */
    List<CourseSelect> findAllBySelect(@Param("did") Integer did,
                                 @Param("mid") Integer mid,
                                 @Param("gid") Integer gid,
                                 @Param("classid") Integer classid,
                                 @Param("sname") String sname);

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
     * @return
     */
    Integer update(@Param("cid") Integer cid,
                   @Param("scid") Integer scid);

    /**
     * 删除学生所选课程（逻辑删除）
     * @param scid
     * @return
     */
    Integer del(Integer scid);

    /**
     * 根据课程id查询课程已选人数和最大选课人数
     * @param cid
     * @return
     */
    Course selCountAndMax(Integer cid);
    /**
     * 根据课程id修改课程以选人数(减)
     * @param cid
     * @return
     */
    Integer updateCountJian(Integer cid);
    /**
     * 根据课程id修改课程以选人数(加)
     * @param cid
     * @return
     */
    Integer updateCountJia(Integer cid);
}
