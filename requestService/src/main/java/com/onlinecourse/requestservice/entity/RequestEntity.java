package com.onlinecourse.requestservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "request")
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @OneToOne
    @JoinColumn(name = "personal_data_id")
    private PersonalDataEntity personalData;

    @OneToOne
    @JoinColumn(name = "course_data_id")
    private CourseDataEntity courseData;
}
