package com.onlinecourses.courseservice.events;

import com.onlinecourses.courseservice.enums.CourseStatus;

public record CourseEvent(String courseName, String courseType, CourseStatus courseStatus) {
}
