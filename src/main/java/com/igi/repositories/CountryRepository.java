package com.igi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igi.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
