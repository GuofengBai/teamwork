package org.businesslogicservice.billsblservice;

import org.po.ComPO;
import org.po.ResultMessage;
import org.po.myDate;

public interface NewInstorageBillsBLService {
	
	public ResultMessage newInstorageBill(myDate date, String GoodsNum, String Destination, String Location);

	public ComPO addGoods(String GoodsNum,myDate inDate, String place, String LocationNum);
	
	public ComPO deleteGoods(String GoodsNum, myDate inDate, String place,
			String LocationNum);
}
