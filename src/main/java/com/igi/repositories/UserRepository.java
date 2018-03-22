package com.igi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
