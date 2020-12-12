package cn.kgc.service;

import cn.kgc.entity.Course;
import cn.kgc.entity.Student;
import cn.kgc.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassinfoMapper classinfoMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private CourseSelectMapper courseSelectMapper;
    @Override
    public Integer add(Student student) {
        //修改班级总人数
        classinfoMapper.updateClassNum(student.getClassid());
        //修改年级总人数
        gradeMapper.updateGradeNum(student.getClassid());
        //修改专业总人数
        majorMapper.updateMajorNum(student.getClassid());
        //修改系部总人数
        departmentMapper.updateDepartmentNum(student.getClassid());
        //添加学生
        studentMapper.add(student);
        //初始化学生选课
        List<Course> courses=studentMapper.findMid(student.getClassid());
        System.out.println(courses);
        System.out.println(student.getClassid());
        for (Course c:courses) {
            studentMapper.addStuCourse(student.getSid(), c.getCid());
            //修改课程以选人数
            courseSelectMapper.updateCountJia(c.getCid());
        }
        return 1;
    }

}
