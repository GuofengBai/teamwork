package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.vo.HEBVO;

public interface NewHallEntruckBillsBLService {

	public ResultMessage addHallEntruckBills(HEBVO vo);
	
	public ResultMessage updateHallEntruckBills(HEBVO vo);

}
