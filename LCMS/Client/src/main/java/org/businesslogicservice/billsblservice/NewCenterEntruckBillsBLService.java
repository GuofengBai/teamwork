package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.myDate;
import org.vo.CEBVO;
import org.vo.StateListVO;

public interface NewCenterEntruckBillsBLService {
	public ResultMessage addCenterEntruckBills(CEBVO vo);
	public ResultMessage updateCenterEntruckBills(CEBVO vo);
	

}
