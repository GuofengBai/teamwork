package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.vo.HDBVO;

public interface NewHallDispatchBillsBLService {
	
	public ResultMessage newHallDispatchBill(HDBVO vo);
	
	public String searchTheGood(String goodNum);
	
	public ResultMessage updateHallDispatchBill(HDBVO vo);
}
