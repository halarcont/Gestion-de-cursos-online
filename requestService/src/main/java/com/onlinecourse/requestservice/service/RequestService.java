package com.onlinecourse.requestservice.service;

import com.onlinecourse.requestservice.entity.CourseEntity;
import com.onlinecourse.requestservice.entity.RequestEntity;

import java.util.List;

public interface RequestService {

    CourseEntity create(CourseEntity courseEntity);

    List<CourseEntity> listCourse();

    public RequestEntity createRequest(RequestEntity requestEntity);
    public RequestEntity updateRequest(RequestEntity requestEntity, Long id);
    public void deleteRequest(Long id);
    public Iterable<RequestEntity> list ();
    public RequestEntity findById(Long id);

}
