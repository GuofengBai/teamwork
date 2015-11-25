package org.businesslogicservice.billsblservice;

import org.po.ComPO;
import org.po.ResultMessage;
import org.po.myDate;

public interface NewOutstorageBillsBLService {
	
	public ResultMessage addOutstorageBills(myDate date, String GoodsNum);
	
	public ComPO searchThePO(String goodNum);

}
