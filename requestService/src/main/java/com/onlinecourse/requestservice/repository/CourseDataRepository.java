package com.onlinecourse.requestservice.repository;

import com.onlinecourse.requestservice.entity.CourseDataEntity;
import com.onlinecourse.requestservice.entity.RequestEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseDataRepository extends CrudRepository<CourseDataEntity, Long>{
}