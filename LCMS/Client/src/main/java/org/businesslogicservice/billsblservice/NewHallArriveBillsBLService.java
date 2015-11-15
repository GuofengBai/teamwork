package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.State;
import org.po.myDate;
import org.po.theGoodState;

public interface NewHallArriveBillsBLService {
	
	public ResultMessage createHallArriveBills(myDate date, String StartPlace, String EntruckNum);

	public theGoodState changeGoodState(theGoodState goodstate, State state);
	
	public ResultMessage newHallArriveBills();
}
