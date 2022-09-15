package com.example.validation.service;

import com.example.validation.converter.StudentConverter;
import com.example.validation.model.ApiResponse;
import com.example.validation.model.Student;
import com.example.validation.model.StudentProjection;
import com.example.validation.pojo.StudentPojo;
import com.example.validation.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ApiResponse implements StudentService {
    private StudentConverter studentConverter;
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentConverter studentConverter, StudentRepository studentRepository) {
        this.studentConverter = studentConverter;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentPojo> getStudentData() {
        // return null;
        List<Student> allStudent = studentRepository.findAll();
        return studentConverter.entityToDto(allStudent);
    }

    @Override
    public ApiResponse searchStudent(Integer id) {

        if (id != null) {
            if (!studentRepository.findById(id).isPresent()) {
                return error("Given student id : " + id + " is not present in database", null);
            }
        }
//        Student student= studentRepository.findById(id);
//        return studentConverter.entityToDto(student);
        return success("student is found in db", studentRepository.findById(id));
    }

    @Override
    public ApiResponse addStudent(StudentPojo studentPojo) {
        Student student = studentConverter.daoToEntity(studentPojo);

        //return studentConverter.entityToDto(student);

        if(student.getStudent_id()==null)
        {
            return success("New student is added",studentRepository.save(student));
        }
        else if(!studentRepository.findById(student.getStudent_id()).isPresent())
        {
            return error("Provided data is not valid..",null);

        }
        return success("Data has been updated of id : "+student.getStudent_id(),studentRepository.save(student));

    }

    @Override
    public StudentProjection getSelectedId(Integer id) {
        return studentRepository.getSelectedData(id);
    }

    @Override
    public ApiResponse findSpecificData() {
        return success("all the Last name and Address are...",studentRepository.getStudentSpecificData());
    }

    @Override
    public ApiResponse fetchStudentData(Integer id) {
        if(id!=null)
        {
            if(!studentRepository.findById(id).isPresent())
            {
                return error("sorry data is not available in db",null);
            }
        }
        return success("userName is ",studentRepository.setUserId(id));
    }


}
