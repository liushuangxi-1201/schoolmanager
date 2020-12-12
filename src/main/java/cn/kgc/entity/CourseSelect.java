package cn.kgc.entity;

import lombok.Data;

@Data
public class CourseSelect {
    private Integer cid;//课程编号
    private Integer scid;//学生选课编号
    private String sname;//学生姓名
    private Integer mid;//专业id
    private String classname;//班级名称
    private String cname;//课程名称
    private Integer ccredit;//学分
    private String studytype;//选修
    private Integer cselcount;//已选人数
    private Integer cmaxcount;//限定人数
    private String stuid; //学号
}
