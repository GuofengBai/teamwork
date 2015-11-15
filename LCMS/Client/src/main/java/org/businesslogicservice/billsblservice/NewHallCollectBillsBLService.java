package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.myDate;

public interface NewHallCollectBillsBLService {
	
	public ResultMessage newHallColletcionBill(myDate date, String name);
	
	public String addGoods(String GoodsNum, double Cash);
	
	public String deleteGoodsCash(String GoodsNum);

}
