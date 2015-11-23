package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.myDate;
import org.vo.StateListVO;

public interface NewCenterEntruckBillsBLService {
	public ResultMessage addCenterEntruckBills(myDate date, String TrafficNum, 
			String HallNum, String Vehicle, String DriverName, String ScouterName, ArrayList<StateListVO> vo);
	public long getPrice(String HallNum);
	

}
