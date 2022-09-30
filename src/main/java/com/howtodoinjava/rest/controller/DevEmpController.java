package com.howtodoinjava.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.howtodoinjava.rest.dao.DevEmpDAO;
import com.howtodoinjava.rest.model.DevopsEmployeesList;
import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.DevopsEmployee;

@RestController
@RequestMapping(path = "/PriyankaDevOpdmap")
public class DevEmpController {

	@Autowired
	private DevEmpDAO PriyankaDao;
	@GetMapping(path = "/DevopsEmployeesList", produces = "application/json")
	public DevopsEmployeesList getPriyankaEmployees() {
		try {
			return PriyankaDao.getAllPriyankaEmployees();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	
	@PostMapping(path = "/addPriyankaemployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addPriyankaEmployee(
			@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
			@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "India") String headerLocation,
			@RequestBody DevopsEmployee demployee) throws Exception {
		try {
			// Generate resource id
			Integer id = PriyankaDao.getAllPriyankaEmployees().getdevopsEmployeeList().size() + 1;
			demployee.setId(id);

			// add resource
			PriyankaDao.addPriyankaEmployee(demployee);

			// Create resource location
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(demployee.getId()).toUri();

			// Send location in response
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	@PostMapping(path = "/addPriyankaemployeeResponse", consumes = "application/json", produces = "application/json")
	public String addPriyankaemployeeResponse(
			@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
			@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
			@RequestBody DevopsEmployee demployee) throws Exception {
		try {
			// Generate resource id
			Integer id = PriyankaDao.getAllPriyankaEmployees().getdevopsEmployeeList().size() + 1;
			demployee.setId(id);

			// add resource
			return PriyankaDao.addPriyankaEmployeeString(demployee).toString();

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
	@PostMapping(path = "/addPriyankaJsonResponse", consumes = "application/json", produces = "application/json")
	public String addPriyankaJsonResponse(
			@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
			@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
			@RequestBody DevopsEmployee demployee) throws Exception {
		try {
			// Generate resource id
			Integer id = PriyankaDao.getAllPriyankaEmployees().getdevopsEmployeeList().size() + 1;
			demployee.setId(id);

			// add resource
			return PriyankaDao.addPriyankaEmployeeJson(demployee).toString();

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

	
	


