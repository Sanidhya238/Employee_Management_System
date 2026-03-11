package com.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.EmployeeDto;
import com.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")

public class EmployeeController {
	
	private EmployeeService employeeService;
	
	//Bulid Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto saveEmployee = employeeService.createEmployee(employeeDto);
		
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}
	
	
	//Build GET Rest API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long empId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(empId);
		return ResponseEntity.ok(employeeDto);
	}
	
	//Build GET All API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//Build Update REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId, 
													  @RequestBody EmployeeDto employeeDto){
		EmployeeDto updatedEmployee = employeeService.updateEmployee(empId, employeeDto);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
	
	//Build Delete REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empId){
		employeeService.deleteEmployee(empId);
		return ResponseEntity.ok("Employee Delete Successfully....! \n ID: "+empId);
	}

}
