package com.onlinecourse.userservice.service;

import com.onlinecourse.userservice.entity.UserEntity;
import com.onlinecourse.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity, String id) {
        Optional<UserEntity> userEntityOld = userRepository.findById(id);
        if(!userEntityOld.isEmpty()){
            userEntityOld = Optional.ofNullable(userEntity);
            return userRepository.save(userEntityOld.get());
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntity> list() {
        return (List<UserEntity>) userRepository.findAll();
    }

}
