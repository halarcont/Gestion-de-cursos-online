package com.onlinecourse.requestservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    private String courseId;
    private String courseName;
    private String courseType;
    private Integer teacherId;
    private List<Integer> studentsId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

}
