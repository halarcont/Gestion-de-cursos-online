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

    /**
     * metodo encargado de crear los cursos y enviar un mensaje al servicio notificationService de "creado"
     * @param courseEntity
     * @return entidad curso creado
     */
    @Override
    public CourseEntity create(CourseEntity courseEntity) {
        var savedCourse = this.courseRepository.save(courseEntity);
        this.kafkaTemplate.send("course-topic", JsonUtils.toJson(
                new CourseEvent(savedCourse.getCourseName(), savedCourse.getCourseType(), CourseStatus.CREATED)
        ));
        return courseRepository.save(courseEntity);
    }

    /**
     * metodo que se encarga de la logica detras del metodo modificar curso
     * @param courseEntity
     * @param id
     * @return entidad curso modificado
     */
    @Override
    public CourseEntity update(CourseEntity courseEntity, String id) {
        Optional<CourseEntity> courseEntityOld = courseRepository.findById(id);
        if(!courseEntityOld.isEmpty()){
            courseEntityOld = Optional.ofNullable(courseEntity);
            return courseRepository.save(courseEntityOld.get());
        }
        return null;
    }

    /**
     * metodo que lista los cursos
     * @return
     */
    @Override
    public List<CourseEntity> list() {
        return courseRepository.findAll();
    }

}
