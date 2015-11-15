package org.businesslogicservice.billsblservice;

import org.po.EXPRESSSTATE;
import org.po.ResultMessage;

public interface UpdateExpressStateBLSerivice {
	
	public ResultMessage updateState(String GoodsNum,EXPRESSSTATE state);

}
