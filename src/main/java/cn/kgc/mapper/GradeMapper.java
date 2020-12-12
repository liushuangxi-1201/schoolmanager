package cn.kgc.mapper;

import cn.kgc.entity.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GradeMapper {
    /**
     * 查询所有年级
     * @param gid
     * @param mid
     * @param did
     * @return
     */
    List<Grade> findAll(@Param("gid") Integer gid,
                        @Param("mid") Integer mid,
                        @Param("did") Integer did);

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
