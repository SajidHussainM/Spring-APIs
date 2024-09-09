package com.company.proj1.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.company.proj1.config.dto.DTO;
import com.company.proj1.config.repository.EmployeeRepository;
import com.company.proj1.entity.EntityEmployee;

import jakarta.persistence.Entity;

@Service
public class EmployeeService {
	@Autowired
	final EmployeeRepository employeeRepository;
	final ModelMapper modelMappper;

	public EmployeeService(EmployeeRepository emp, ModelMapper modelMappper) {
		super();
		this.employeeRepository = emp;
		this.modelMappper = modelMappper;
	}
	
			
	@SuppressWarnings("deprecation")
	public DTO getEmployeeById(int id) {
		EntityEmployee enitityEmployee = employeeRepository.getById(id);
		return modelMappper.map(enitityEmployee, DTO.class);
	}
	
	public DTO addEmployee(DTO dto) {
		EntityEmployee entityEmployee = employeeRepository.save(modelMappper.map(dto, EntityEmployee.class));
		return modelMappper.map(entityEmployee, DTO.class);
	}
	
	public boolean delteEmployee(int id) {	
		if (!employeeRepository.existsById(id)) {
			return false;
		}
		employeeRepository.deleteById(id);
		return true;
	}

	public List<DTO> getAllEmployees() {
		List<DTO> list = new ArrayList<>();
		
		for( EntityEmployee emp : employeeRepository.findAll()) {
			list.add(modelMappper.map(emp, DTO.class));
		}
		return list;
	}
}
