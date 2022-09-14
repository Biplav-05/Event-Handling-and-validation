package com.example.validation.controller;

import com.example.validation.pojo.StudentPojo;
import com.example.validation.service.StudentInterface;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("student/")
public class StudentController {

    private final StudentInterface studentInterface;

    public StudentController(StudentInterface studentInterface) {
        this.studentInterface = studentInterface;
    }

    @GetMapping("getDataByPojo")
    public List<StudentPojo> getStudent()
    {
            return studentInterface.getStudentData();
    }

    @GetMapping("findBy/{id}")
    public StudentPojo findStudent(@PathVariable Integer id)
    {
        return studentInterface.searchStudent(id);
    }
    @PostMapping("saveStudent")
    public StudentPojo saveStudent(@RequestBody @Valid StudentPojo studentPojo)
    {
        return studentInterface.addStudent(studentPojo);
    }

}
