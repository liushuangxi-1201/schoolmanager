package cn.kgc.mapper;

import cn.kgc.entity.Major;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorMapper {
    /**
     * 查询专业详情
     * @param dname
     * @param mname
     * @return
     */
    List<Major> findByDnameAndMname(@Param("dname") String dname,
                                    @Param("mname") String mname);

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
