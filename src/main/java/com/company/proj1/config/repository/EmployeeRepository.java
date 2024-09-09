package com.company.proj1.config.repository;

import org.springframework.stereotype.Repository;

import com.company.proj1.entity.EntityEmployee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<EntityEmployee, Integer>{
	
}
