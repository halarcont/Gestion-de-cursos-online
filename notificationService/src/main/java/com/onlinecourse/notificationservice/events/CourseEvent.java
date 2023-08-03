package com.onlinecourse.notificationservice.events;

import com.onlinecourse.notificationservice.models.enums.CourseStatus;

public record CourseEvent(String courseName, String courseType, CourseStatus courseStatus) {
}
