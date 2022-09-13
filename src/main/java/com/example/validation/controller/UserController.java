package com.example.validation.controller;

import com.example.validation.exception.userNotFoundException;
import com.example.validation.model.User;
import com.example.validation.pojo.UserRequest;
import com.example.validation.service.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("database/")
public class UserController {

    private UserServiceInterface userServiceInterface;

    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }
    @PostMapping("signup")
    public ResponseEntity<User> saveAllUser(@RequestBody @Valid UserRequest userRequest)
    {
        return new ResponseEntity<>(userServiceInterface.saveUserData(userRequest), HttpStatus.CREATED);

    }
    @GetMapping("fetchData")
    public ResponseEntity<List<User>> allData()
    {
       return ResponseEntity.ok(userServiceInterface.getAllUser());
    }
    @GetMapping("find/{ids}")
    public ResponseEntity<User> searchUser(@PathVariable Integer ids) throws userNotFoundException {
       return ResponseEntity.ok(userServiceInterface.searchSpecificUser(ids));
    }
}
