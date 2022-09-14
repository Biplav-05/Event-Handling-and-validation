package com.example.validation.service;

import com.example.validation.pojo.StudentPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentInterface {
    List<StudentPojo> getStudentData();

    StudentPojo searchStudent(Integer id);

    StudentPojo addStudent(StudentPojo studentPojo);
}
