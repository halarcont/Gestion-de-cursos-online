package com.onlinecourses.courseservice.service;

import com.onlinecourses.courseservice.entity.CourseEntity;
import com.onlinecourses.courseservice.event.CourseCreatedEvent;
import com.onlinecourses.courseservice.event.Event;
import com.onlinecourses.courseservice.event.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class EventService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.customer.name:customers}")
    private String topicCourse;

    public void publish(CourseEntity courseEntity) {

        CourseCreatedEvent created = new CourseCreatedEvent();
        created.setData(courseEntity);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCourse, created);
    }
}
