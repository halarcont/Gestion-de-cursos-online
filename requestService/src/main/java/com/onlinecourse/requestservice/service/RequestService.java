package com.onlinecourse.requestservice.service;

import com.onlinecourse.requestservice.entity.RequestEntity;

public interface RequestService {

    public RequestEntity createRequest(RequestEntity requestEntity);
    public RequestEntity updateRequest(RequestEntity requestEntity, Long id);
    public void deleteRequest(Long id);
    public Iterable<RequestEntity> list ();
    public RequestEntity findById(Long id);

}
