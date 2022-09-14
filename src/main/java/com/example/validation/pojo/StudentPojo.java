package com.example.validation.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPojo {
    private Integer student_id;
    @NotBlank(message = "First Name shouldn't be blank")
    private String first_name;
    @NotNull(message = "Last Name shouldn't be null")
    private String last_name;
    @NotBlank(message ="Address should not be blank")
    private String address;


}
