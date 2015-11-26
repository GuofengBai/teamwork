package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.myDate;
import org.vo.StateListVO;

public interface NewHallCollectBillsBLService {
	
	public ResultMessage addHallCollectionBills(myDate date,String idNum, String name, String total, ArrayList<StateListVO> list);
	

}
