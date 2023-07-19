package com.onlinecourses.courseservice.repository;

import com.onlinecourses.courseservice.entity.CourseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import reactor.core.publisher.Mono;

public interface CourseRepository extends MongoRepository<CourseEntity, String> {
}
