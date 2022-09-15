package com.example.validation.converter;

import com.example.validation.model.Student;
import com.example.validation.pojo.StudentPojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentConverter {

    @Autowired
    private ModelMapper modelMapper;
    public StudentPojo entityToDto(Student student)
    {
        StudentPojo studentPojo = this.modelMapper.map(student,StudentPojo.class);
        //StudentPojo studentPojo = new StudentPojo();
//        studentPojo.setStudent_id(student.getStudent_id());
//        studentPojo.setFirst_name(student.getFirst_name());
//        studentPojo.setLast_name(student.getLast_name());
//        studentPojo.setAddress(student.getAddress());
        return studentPojo;
    }
    public List<StudentPojo> entityToDto(List<Student> student) {
       // return student.stream().map(e->entityToDto(e)).collect(Collectors.toList());
      return   student.stream().map(a->modelMapper.map(a,StudentPojo.class)).collect(Collectors.toList());
    }



    public Student daoToEntity(StudentPojo studentPojo)
    {
        Student student = this.modelMapper.map(studentPojo,Student.class);
//        student.setStudent_id(studentPojo.getStudent_id());
//        student.setFirst_name(studentPojo.getFirst_name());
//        student.setLast_name(studentPojo.getLast_name());
//        student.setAddress(studentPojo.getAddress());
        return student;
    }
    public List<Student> daoToEntity(List<StudentPojo> studentPojo)
    {
        //return studentPojo.stream().map(a->daoToEntity(a)).collect(Collectors.toList());
        return studentPojo.stream().map(pojo->modelMapper.map(pojo,Student.class)).collect(Collectors.toList());
    }
}
