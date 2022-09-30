package com.howtodoinjava.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.howtodoinjava.rest.dao.EmployeeDAO;
import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@RestController
@RequestMapping(path = "/employeesmap")
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDao;
	@GetMapping(path = "/employees", produces = "application/json")
	public Employees getEmployees() {
		try {
			return employeeDao.getAllEmployees();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	@PostMapping(path = "/addemployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(
			@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
			@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
			@RequestBody Employee employee) throws Exception {
		try {
			// Generate resource id
			Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
			employee.setId(id);

			// add resource
			employeeDao.addEmployee(employee);

			// Create resource location
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(employee.getId()).toUri();

			// Send location in response
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	
	@PostMapping(path = "/addemployeeResponse", consumes = "application/json", produces = "application/json")
	public String addEmployeeResponse(
			@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
			@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
			@RequestBody Employee employee) throws Exception {
		try {
			// Generate resource id
			Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
			employee.setId(id);

			// add resource
			return employeeDao.addEmployeeString(employee).toString();

			// Create resource location
			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			//		.buildAndExpand(employee.getId()).toUri();

			// Send location in response
			//return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	
	@PostMapping(path = "/addemployeeJsonResponse", consumes = "application/json", produces = "application/json")
	public String addemployeeJsonResponse(
			@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
			@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
			@RequestBody Employee employee) throws Exception {
		try {
			// Generate resource id
			Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
			employee.setId(id);

			// add resource
			return employeeDao.addEmployeeJson(employee).toString();

			// Create resource location
			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			//		.buildAndExpand(employee.getId()).toUri();

			// Send location in response
			//return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
}
