package com.example.validation.service;

import com.example.validation.exception.userNotFoundException;
import com.example.validation.model.User;
import com.example.validation.pojo.UserRequest;
import com.example.validation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceInterfaceImple implements UserServiceInterface {
    UserRepository userRepository;

    public UserServiceInterfaceImple(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserData(UserRequest userRequest) {
        User user = User.build(0,userRequest.getName(),userRequest.getAddress(),userRequest.getEmail(),
                userRequest.getNationality());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User searchSpecificUser(Integer ids) throws userNotFoundException {
       User user= userRepository.findByUserId(ids);
       if(user!=null)
       {
           return user;
       }
       else
       {
           throw new userNotFoundException("User not found with id : "+ids);
       }

    }

}
