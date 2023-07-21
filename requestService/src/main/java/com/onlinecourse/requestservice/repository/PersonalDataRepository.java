package com.onlinecourse.requestservice.repository;

import com.onlinecourse.requestservice.entity.PersonalDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonalDataRepository extends CrudRepository<PersonalDataEntity, Long>{
}