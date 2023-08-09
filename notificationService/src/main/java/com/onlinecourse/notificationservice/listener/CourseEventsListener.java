package com.onlinecourse.notificationservice.listener;

import com.onlinecourse.notificationservice.events.CourseEvent;
import com.onlinecourse.notificationservice.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseEventsListener {

    /**
     * clase que se comunica con el topico de cursos para conformar el mensaje de notificacion
     * @param message
     */
    @KafkaListener(topics = "course-topic")
    public void handleOrdersNotifications(String message) {
        var courseEvent = JsonUtils.fromJson(message, CourseEvent.class);

        log.info("Course {} event received with name: {} type: {} ", courseEvent.courseStatus(), courseEvent.courseName(), courseEvent.courseType());
    }
}
