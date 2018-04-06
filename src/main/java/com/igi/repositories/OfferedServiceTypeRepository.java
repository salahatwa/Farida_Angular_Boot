package com.igi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igi.entities.OfferedServiceType;

@Repository
public interface OfferedServiceTypeRepository extends CrudRepository<OfferedServiceType, Long>{

}
