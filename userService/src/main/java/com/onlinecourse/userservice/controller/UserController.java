package com.onlinecourse.userservice.controller;

import com.onlinecourse.userservice.entity.UserEntity;
import com.onlinecourse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity updateUser(@RequestBody UserEntity userEntity, @PathVariable String id){
        return userService.updateUser(userEntity, id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> listUsers(){
        return userService.list();
    }


}
