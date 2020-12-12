package cn.kgc.controller;

import cn.kgc.entity.Student;
import cn.kgc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/toAddStudent")
    public String toAddStudent() {
        return "/view/student/addStudent";
    }

    @PostMapping("/add")
    public Boolean add(Student student) {

        return true;
    }
}
