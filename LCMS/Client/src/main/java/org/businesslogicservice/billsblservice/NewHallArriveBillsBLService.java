package org.businesslogicservice.billsblservice;


import org.po.ResultMessage;

import org.vo.HABVO;


public interface NewHallArriveBillsBLService {
		
	public ResultMessage addHallArriveBills(HABVO vo);
	
	public ResultMessage updateHallArriveBills(HABVO vo);
}
