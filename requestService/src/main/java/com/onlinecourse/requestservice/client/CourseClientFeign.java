package com.onlinecourse.requestservice.client;

import com.onlinecourse.requestservice.entity.CourseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(name = "courseService")
public interface CourseClientFeign {

    @PostMapping("/api/courses/create")
    public CourseEntity createCourse(@RequestBody CourseEntity courseEntity);

    @GetMapping("/api/courses")
    public List<CourseEntity> listCourse();
}
