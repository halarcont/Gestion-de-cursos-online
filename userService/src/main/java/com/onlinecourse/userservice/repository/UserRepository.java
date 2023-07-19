package com.onlinecourse.userservice.repository;

import com.onlinecourse.userservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
