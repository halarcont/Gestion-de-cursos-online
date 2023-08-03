package com.onlinecourses.courseservice.service;

import com.onlinecourses.courseservice.entity.CourseEntity;
import com.onlinecourses.courseservice.enums.CourseStatus;
import com.onlinecourses.courseservice.events.CourseEvent;
import com.onlinecourses.courseservice.repository.CourseRepository;
import com.onlinecourses.courseservice.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    private final KafkaTemplate<String,String> kafkaTemplate;


    @Override
    public CourseEntity create(CourseEntity courseEntity) {
        var savedCourse = this.courseRepository.save(courseEntity);
        this.kafkaTemplate.send("course-topic", JsonUtils.toJson(
                new CourseEvent(savedCourse.getCourseName(), savedCourse.getCourseType(), CourseStatus.CREATED)
        ));
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
