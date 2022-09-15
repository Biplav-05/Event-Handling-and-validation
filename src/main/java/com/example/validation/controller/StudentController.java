package com.example.validation.controller;

import com.example.validation.model.ApiResponse;
import com.example.validation.pojo.StudentPojo;
import com.example.validation.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("student/")
public class StudentController extends ApiResponse {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("getDataByPojo")
    public ApiResponse getStudent() {
        return success("All data are generated...", studentService.getStudentData());
    }

    @GetMapping("findBy/{ids}")
    public ApiResponse findStudent(@PathVariable Integer ids) {
        return studentService.searchStudent(ids);
    }

    @PostMapping("saveAndUpdate")
    public ApiResponse saveStudent(@RequestBody @Valid StudentPojo studentPojo) {
        return studentService.addStudent(studentPojo);
    }

    @GetMapping("getDataByProjector/{id}")
    public ApiResponse getPojoData(@PathVariable Integer id)
    {
        return success("helo",studentService.getSelectedId(id));
    }
    @GetMapping("getDataToStudentPojoTest")
    public ApiResponse getStudentimitedData()
    {
        return studentService.findSpecificData();
    }
    @GetMapping("ConcatInProjection/{id}")
    public ApiResponse concatData(@PathVariable Integer id)
    {
        return studentService.fetchStudentData(id);
    }
}
