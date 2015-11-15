package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.myDate;

public interface NewHallDispatchBillsBLService {
	
	public ResultMessage newHallDispatchBill(myDate date, String name, String GoodsNum);

	public String[] searchGoods(String GoodsNum);
}
