package com.onlinecourse.requestservice.repository;

import com.onlinecourse.requestservice.entity.RequestEntity;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository  extends CrudRepository<RequestEntity, Long>{
}