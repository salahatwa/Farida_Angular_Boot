package com.igi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igi.entities.ServiceConfigMap;

@Repository
public interface ServiceConfigMapRepository extends JpaRepository<ServiceConfigMap, Integer>{

}
