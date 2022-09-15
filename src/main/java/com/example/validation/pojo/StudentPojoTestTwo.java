package com.example.validation.pojo;

import org.springframework.beans.factory.annotation.Value;

public interface StudentPojoTestTwo {
    @Value("#{target.student_id +''+ target.first_name}")
    public String getIdAndFirstName();
    public String getAddress();
}
