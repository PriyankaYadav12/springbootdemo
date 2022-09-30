package com.howtodoinjava.rest.dao;

import com.howtodoinjava.rest.model.DevopsEmployee;

public class MainDevo {
	
	public static void main(String[] args) {
		
		JdbcDAO student = new JdbcDAO();
		DevopsEmployee devo = new DevopsEmployee();
		devo.setEmail("Priyanka");
		devo.setFirstName("Emir");
		devo.setLastName("Koshgul");
		devo.setId(1);
		
		DevopsEmployee priya = new DevopsEmployee();
		priya.setFirstName("Sakshi");
		priya.setId(6);
		// Adding Data
		student.add(devo);
		// Deleting Data
		student.delete(7);
		// Updating Data
		student.update(devo);
		// Displaying Data
		student.findAll();
	}

	
}
