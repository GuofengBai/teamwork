package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.myDate;

public interface NewHallDispatchBillsBLService {
	
	public ResultMessage newHallDispatchBill(myDate date,String idNum, String name, String GoodsNum);
	
	public String searchTheGood(String goodNum);
}
