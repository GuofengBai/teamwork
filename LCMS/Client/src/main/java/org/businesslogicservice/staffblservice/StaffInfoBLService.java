package org.businesslogicservice.staffblservice;

import org.po.POSITION;
import org.po.WORKPLACE;
import org.po.ResultMessage;

public interface StaffInfoBLService {
	
	public ResultMessage setSalary(String type,double parameter);
	
	public ResultMessage setPosition(POSITION position);
	
	public ResultMessage setWorkPlace(WORKPLACE workplace);
	
	public ResultMessage save();
	
}
