package com.onlinecourses.courseservice.service;

import com.onlinecourses.courseservice.entity.CourseEntity;

import java.util.List;

public interface CourseService {
    public CourseEntity create (CourseEntity courseEntity);
    public CourseEntity update (CourseEntity courseEntity, String id);
    public List<CourseEntity> list ();
}
