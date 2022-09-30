package com.howtodoinjava.rest.model;

import java.util.ArrayList;
import java.util.List;

public class APIModelList {
	
private List<APIModel> apiModelList;
	
	public List<APIModel> getapiModelList(){
	if(apiModelList==null) {
		apiModelList = new ArrayList<>();
	}
	return apiModelList; 

}
	public void setAPIModelList(List<APIModel> apimodelList) {
        this.apiModelList = apimodelList;
    }
}


