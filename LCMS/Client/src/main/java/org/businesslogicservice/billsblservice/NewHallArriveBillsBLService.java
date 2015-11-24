package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.State;
import org.po.myDate;
import org.po.theGoodState;
import org.vo.StateListVO;

public interface NewHallArriveBillsBLService {
		
	public ResultMessage addHallArriveBills(myDate date,String startPlace,String entruckNum ,ArrayList<StateListVO> list);
}
