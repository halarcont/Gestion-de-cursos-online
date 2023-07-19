package com.onlinecourses.courseservice.controller;

import com.onlinecourses.courseservice.entity.CourseEntity;
import com.onlinecourses.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseEntity createCourse(@RequestBody CourseEntity courseEntity){
        return courseService.create(courseEntity);
    }

    @PutMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseEntity updateCourse(@RequestBody CourseEntity courseEntity,@PathVariable String id){
        return courseService.update(courseEntity,id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseEntity> listCourse(){
        return courseService.list();
    }

}
