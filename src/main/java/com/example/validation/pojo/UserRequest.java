package com.example.validation.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "Username cannot be null..")
    private String name;
    @NotNull(message = "address cannot be null")
    private String address;
    //@Email(message = "please enter valid email")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message ="please enter valid email" )
    private String email;
    @NotBlank (message = "nationality cannot be blank")
    private String nationality;
}
