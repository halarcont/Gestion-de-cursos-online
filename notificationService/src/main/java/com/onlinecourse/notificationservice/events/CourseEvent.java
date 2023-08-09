package com.onlinecourse.notificationservice.events;

import com.onlinecourse.notificationservice.models.enums.CourseStatus;

/**
 * clase record para almacenar los datos del evento curso para los mensajes de notificacion
 * @param courseName
 * @param courseType
 * @param courseStatus
 */
public record CourseEvent(String courseName, String courseType, CourseStatus courseStatus) {
}
