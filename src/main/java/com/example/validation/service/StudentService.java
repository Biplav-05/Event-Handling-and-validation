package com.example.validation.service;

import com.example.validation.model.ApiResponse;
import com.example.validation.model.StudentProjection;
import com.example.validation.pojo.StudentPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentPojo> getStudentData();

    ApiResponse searchStudent(Integer id);

    ApiResponse addStudent(StudentPojo studentPojo);


    StudentProjection getSelectedId(Integer id);

    ApiResponse findSpecificData();

    ApiResponse fetchStudentData(Integer id);
}
