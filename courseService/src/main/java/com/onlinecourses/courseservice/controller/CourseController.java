package com.onlinecourses.courseservice.controller;

import com.onlinecourses.courseservice.entity.CourseEntity;
import com.onlinecourses.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * clase donde se evidencian los endpoints de cursos
 */
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * este metodo se encarga de crear un curso
     * @param courseEntity
     * @return un response status 201 created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseEntity createCourse(@RequestBody CourseEntity courseEntity){
        return courseService.create(courseEntity);
    }

    /**
     * metodo encargado de modificar un curso especificado por el id pasado por parametro
     * @param courseEntity
     * @param id
     * @return response status OK
     */
    @PutMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseEntity updateCourse(@RequestBody CourseEntity courseEntity,@PathVariable String id){
        return courseService.update(courseEntity,id);
    }

    /**
     * metodo encargado de listar todos los cursos
     * @return la lista de cursos
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseEntity> listCourse(){
        return courseService.list();
    }

}
