package com.example.springboot.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.lms.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
