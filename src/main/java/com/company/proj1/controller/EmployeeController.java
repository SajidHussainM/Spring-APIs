package com.company.proj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.proj1.config.dto.DTO;
import com.company.proj1.services.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	@Autowired
	private final EmployeeService employeeService; 
	
	EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("")
	public List<DTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public DTO findEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping()
	public DTO addEmployee(@RequestBody DTO dto) {	
		if (dto == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
		return employeeService.addEmployee(dto);
	}
//	
	@DeleteMapping("/{id}") 
	public boolean deleteEmployee(@PathVariable int id) {
		return employeeService.delteEmployee(id);
	}
}
