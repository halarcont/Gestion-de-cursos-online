package com.onlinecourses.courseservice.service;

import com.onlinecourses.courseservice.entity.CourseEntity;
import com.onlinecourses.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseEntity create(CourseEntity courseEntity) {
        courseEntity.setCreatedAt(new Date());
        return courseRepository.save(courseEntity);
    }

    @Override
    public CourseEntity update(CourseEntity courseEntity, String id) {
        Optional<CourseEntity> courseEntityOld = courseRepository.findById(id);
        if(!courseEntityOld.isEmpty()){
            courseEntityOld = Optional.ofNullable(courseEntity);
            return courseRepository.save(courseEntityOld.get());
        }
        return null;
    }

    @Override
    public List<CourseEntity> list() {
        return courseRepository.findAll();
    }

}
