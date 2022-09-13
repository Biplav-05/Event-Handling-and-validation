package com.example.validation.service;

import com.example.validation.exception.userNotFoundException;
import com.example.validation.model.User;
import com.example.validation.pojo.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInterface {
 public User saveUserData(UserRequest userRequest);

    public List<User> getAllUser();

    User searchSpecificUser(Integer ids) throws userNotFoundException;
}
