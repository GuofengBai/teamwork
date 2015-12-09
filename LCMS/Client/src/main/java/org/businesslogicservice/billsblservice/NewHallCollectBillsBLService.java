package org.businesslogicservice.billsblservice;


import org.po.ResultMessage;
import org.vo.HCBVO;

public interface NewHallCollectBillsBLService {
	
	public ResultMessage addHallCollectionBills(HCBVO vo);
	
	public ResultMessage updateHallCollectionBills(HCBVO vo);
	

}
