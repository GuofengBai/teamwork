package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.myDate;

public interface NewHallArriveBillsBLService {
	
	public ResultMessage createHallArriveBills(myDate date, String StartPlace, String EntruckNum);

	public theGoodState changeGoodState(theGoodState goodstate, State state);
	
	public ResultMessage newHallArriveBills();
}
