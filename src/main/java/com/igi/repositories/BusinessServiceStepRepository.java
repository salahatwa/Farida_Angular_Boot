package com.igi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igi.entities.BusinessServiceStep;

@Repository
public interface BusinessServiceStepRepository extends CrudRepository<BusinessServiceStep, Long>{

}
