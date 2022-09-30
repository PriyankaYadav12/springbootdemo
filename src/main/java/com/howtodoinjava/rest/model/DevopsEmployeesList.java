package com.howtodoinjava.rest.model;

import java.util.ArrayList;
import java.util.List;

public class DevopsEmployeesList {
	
	private List<DevopsEmployee> devopsEmployeeList;
	
	public List<DevopsEmployee> getdevopsEmployeeList(){
	if(devopsEmployeeList==null) {
		devopsEmployeeList = new ArrayList<>();
	}
	return devopsEmployeeList;

}
	public void setDevopsEmployeeList(List<DevopsEmployee> devopsemployeeList) {
        this.devopsEmployeeList = devopsemployeeList;
    }
}
