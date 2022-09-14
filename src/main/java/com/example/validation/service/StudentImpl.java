package com.example.validation.service;

import com.example.validation.converter.StudentConverter;
import com.example.validation.model.Student;
import com.example.validation.pojo.StudentPojo;
import com.example.validation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentInterface{

    @Autowired
    private StudentConverter studentConverter;

    private StudentRepository studentRepository;

    public StudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentPojo> getStudentData() {
       // return null;
        List<Student> allStudent= studentRepository.findAll();
        return studentConverter.entityToDto(allStudent);
    }

    @Override
    public StudentPojo searchStudent(Integer id) {

        Student student= studentRepository.findById(id).orElse(null);
        return studentConverter.entityToDto(student);
    }

    @Override
    public StudentPojo addStudent(StudentPojo studentPojo) {
        Student student=studentConverter.daoToEntity(studentPojo);
        student=studentRepository.save(student);
        return studentConverter.entityToDto(student);

    }
}
