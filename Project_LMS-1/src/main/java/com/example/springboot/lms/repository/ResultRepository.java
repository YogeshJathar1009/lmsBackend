package com.example.springboot.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.lms.model.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {

}
