package com.howtodoinjava.rest.dao;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.rest.model.DevopsEmployee;
import com.howtodoinjava.rest.model.DevopsEmployeesList;

@Repository
public class DevEmpDAO {
	
private static DevopsEmployeesList list = new DevopsEmployeesList();
    
    static 
    {
        list.getdevopsEmployeeList().add(new DevopsEmployee(1, "Kemal", "kkoshgul", "Koshgul@gmail.com"));
        list.getdevopsEmployeeList().add(new DevopsEmployee(2, "Priyanka", "Yadav", "py@gmail.com"));
        list.getdevopsEmployeeList().add(new DevopsEmployee(3, "Sakshi", "Chalke", "skc@gmail.com"));
    }
    
    public DevopsEmployeesList getAllPriyankaEmployees() 
    {
        return list;
    }
    public void addPriyankaEmployee(DevopsEmployee demployee) {
        list.getdevopsEmployeeList().add(demployee);
        
    }
    
    public DevopsEmployee addPriyankaEmployeeString(DevopsEmployee demployee) {
        list.getdevopsEmployeeList().add(demployee);
        return demployee;
    }
    
    public String addPriyankaEmployeeJson(DevopsEmployee demployee) {
        list.getdevopsEmployeeList().add(demployee);
        ObjectMapper mapper = new ObjectMapper();
        try {
			return mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
    }
	
}



