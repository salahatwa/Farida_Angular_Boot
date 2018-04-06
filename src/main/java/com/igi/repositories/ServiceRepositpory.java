package com.igi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igi.entities.Service;

@Repository
public interface ServiceRepositpory extends JpaRepository<Service, Long> {

}
