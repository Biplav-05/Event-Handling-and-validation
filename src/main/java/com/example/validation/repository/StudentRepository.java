package com.example.validation.repository;

import com.example.validation.model.Student;
import com.example.validation.model.StudentProjection;
import com.example.validation.pojo.StudentPojoTest;
import com.example.validation.pojo.StudentPojoTestTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    @Query(value = "select first_name,last_name,address from student where student_id=?1",
            nativeQuery = true)
    StudentProjection getSelectedData(Integer id);

    @Query(value = "select last_name,address from student",nativeQuery = true)
    List<StudentPojoTest>  getStudentSpecificData();


    //Concatinating the two column of entity into one object
    @Query(value = "select * from student where student_id=?1",nativeQuery = true)
    StudentPojoTestTwo setUserId( Integer id);

}
