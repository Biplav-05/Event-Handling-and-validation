package com.example.validation.converter;

import com.example.validation.controller.StudentController;
import com.example.validation.model.Student;
import com.example.validation.pojo.StudentPojo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {

    public StudentPojo entityToDto(Student student)
    {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setStudent_id(student.getStudent_id());
        studentPojo.setFirst_name(student.getFirst_name());
        studentPojo.setLast_name(student.getLast_name());
        studentPojo.setAddress(student.getAddress());
        return studentPojo;
    }
    public List<StudentPojo> entityToDto(List<Student> student) {
        return student.stream().map(e->entityToDto(e)).collect(Collectors.toList());
    }

    public Student daoToEntity(StudentPojo studentPojo)
    {
        Student student = new Student();
        student.setStudent_id(studentPojo.getStudent_id());
        student.setFirst_name(studentPojo.getFirst_name());
        student.setLast_name(studentPojo.getLast_name());
        student.setAddress(studentPojo.getAddress());
        return student;
    }
    public List<Student> daoToEntity(List<StudentPojo> studentPojo)
    {
        return studentPojo.stream().map(a->daoToEntity(a)).collect(Collectors.toList());
    }
}
