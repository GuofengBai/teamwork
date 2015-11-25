package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.myDate;
import org.vo.StateListVO;

public interface NewHallEntruckBillsBLService {

	public ResultMessage addHallEntruckBills(myDate date, String entruckNum,
			String hallNum, String aimNum, String carNum, String driverName, ArrayList<StateListVO> list);

}
