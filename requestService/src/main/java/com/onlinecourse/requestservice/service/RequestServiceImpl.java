package com.onlinecourse.requestservice.service;

import com.onlinecourse.requestservice.entity.RequestEntity;
import com.onlinecourse.requestservice.repository.CourseDataRepository;
import com.onlinecourse.requestservice.repository.PersonalDataRepository;
import com.onlinecourse.requestservice.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Autowired
    private CourseDataRepository courseDataRepository;
    @Override
    public RequestEntity createRequest(RequestEntity requestEntity) {
        requestEntity.setCourseData(courseDataRepository.save(requestEntity.getCourseData()));
        requestEntity.setPersonalData(personalDataRepository.save(requestEntity.getPersonalData()));
        return requestRepository.save(requestEntity);
    }

    @Override
    public RequestEntity updateRequest(RequestEntity requestEntity, Long id) {
        return null;
    }

    @Override
    public void deleteRequest(Long id) {

    }

    @Override
    public Iterable<RequestEntity> list() {
        return requestRepository.findAll();
    }

    @Override
    public RequestEntity findById(Long id) {
        return null;
    }
}
