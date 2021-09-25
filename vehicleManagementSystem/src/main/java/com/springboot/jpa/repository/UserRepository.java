package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
