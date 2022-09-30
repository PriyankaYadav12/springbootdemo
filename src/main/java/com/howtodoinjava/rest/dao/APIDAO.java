package com.howtodoinjava.rest.dao;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.rest.model.APIModel;
import com.howtodoinjava.rest.model.APIModelList;
import com.howtodoinjava.rest.model.DevopsEmployee;
import com.howtodoinjava.rest.model.DevopsEmployeesList;

@Repository
public class APIDAO {
	
private static APIModelList list = new APIModelList();
    
    static 
    {
        list.getapiModelList().add(new APIModel(1, "Luca", "kkoshgul"));
        list.getapiModelList().add(new APIModel(2, "Moanaa", "Arbito"));
        list.getapiModelList().add(new APIModel(3, "Arasto", "rutera"));
    }
    
    public APIModelList getAllPriyankaModel()  //
    {
        return list;
    }
    public void addPriyankaModel(APIModel demodel) {
        list.getapiModelList().add(demodel);
        
    }
    
    public APIModel addPriyankaModelString(APIModel demodel) {
        list.getapiModelList().add(demodel);
        return demodel;
    }
    
    public String addPriyankaModelJson(APIModel demodel) {
        list.getapiModelList().add(demodel);
        ObjectMapper mapper = new ObjectMapper();
        try {
			return mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
    }
	
}

