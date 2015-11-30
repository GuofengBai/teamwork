package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.State;
import org.po.myDate;
import org.po.theGoodState;
import org.vo.HABVO;
import org.vo.StateListVO;

public interface NewHallArriveBillsBLService {
		
	public ResultMessage addHallArriveBills(HABVO vo);
}
