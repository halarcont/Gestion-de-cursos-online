package com.onlinecourses.courseservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * clase que representa la entidad curso
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String courseId;
    private String courseName;
    private String courseType;
    private Integer teacherId;
    private List<Integer> studentsId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

}
