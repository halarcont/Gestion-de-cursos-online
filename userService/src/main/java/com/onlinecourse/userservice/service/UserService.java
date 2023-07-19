package com.onlinecourse.userservice.service;

import com.onlinecourse.userservice.entity.UserEntity;

import java.util.List;

public interface UserService {

    public UserEntity createUser(UserEntity userEntity);
    public UserEntity updateUser(UserEntity userEntity, String id);
    public void deleteById(String id);
    public List<UserEntity> list ();
}
