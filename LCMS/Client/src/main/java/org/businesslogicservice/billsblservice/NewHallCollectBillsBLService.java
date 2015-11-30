package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.myDate;
import org.vo.HCBVO;
import org.vo.StateListVO;

public interface NewHallCollectBillsBLService {
	
	public ResultMessage addHallCollectionBills(HCBVO vo);
	

}
