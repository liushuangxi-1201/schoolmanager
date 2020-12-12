package cn.kgc.mapper;

import cn.kgc.entity.Course;
import cn.kgc.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    /**
     * 添加学生
     * @param student
     * @return
     */
    Integer add(Student student);

    /**
     * 添加学生选课(做初始化学生添加必修)
     * @param sid
     * @param cid
     * @return
     */
    Integer addStuCourse(@Param("sid") Integer sid,
                         @Param("cid") Integer cid);

    /**
     * 根据班级id查询该专业必修课
     * @param classid
     * @return
     */
    List<Course> findMid(Integer classid);
}
