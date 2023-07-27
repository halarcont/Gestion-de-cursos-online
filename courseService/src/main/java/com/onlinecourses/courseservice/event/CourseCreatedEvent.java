package com.onlinecourses.courseservice.event;

import com.onlinecourses.courseservice.entity.CourseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CourseCreatedEvent extends Event<CourseEntity> {

}
