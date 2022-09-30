package com.howtodoinjava.rest.controller;

import java.io.StringWriter;
import java.net.URI;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.rest.JDBC.ConnectionFact;
import com.howtodoinjava.rest.dao.DevEmpDAO;
import com.howtodoinjava.rest.dao.JdbcDAO;
import com.howtodoinjava.rest.model.DevopsEmployee;
import com.howtodoinjava.rest.model.DevopsEmployeesList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping(path = "/PriyankaJDBCDao")
public class JdbcDAOController {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	@Autowired
	private DevEmpDAO PriyankaDao;
	private JdbcDAO PriyankaDevEmployee;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFact.getInstance().getConnection();
		return conn;
		
	}

	@GetMapping(path = "/DevOpsGetEMployee", produces = "application/json")
	public String getDevOpsEmpData() {
		List<String> data = new ArrayList<String>();
		JSONArray ja = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			String queryString = "SELECT * FROM devops";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("id " + resultSet.getInt("id")
						+ ", firstName " + resultSet.getString("firstName") + ", lastName "
						+ resultSet.getString("lastName") + ", email "
						+ resultSet.getString("Email"));
				
				JSONObject obj = new JSONObject();
				obj.put("id",resultSet.getInt("id"));
				obj.put("firstName",resultSet.getString("firstName"));
				obj.put("lastName",resultSet.getString("lastName"));
				obj.put("Email",resultSet.getString("Email"));
				//data.add("Id"+resultSet.getInt("id")); 
				//data.add(resultSet.getString("firstName"));
				//data.add(resultSet.getString("lastName"));
				//data.add(resultSet.getString("Email"));	
				ja.add(obj);
			}
			return ja.toString();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

	
	
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
