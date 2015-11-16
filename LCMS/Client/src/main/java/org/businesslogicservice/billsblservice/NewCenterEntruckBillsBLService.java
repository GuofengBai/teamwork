package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.myDate;

public interface NewCenterEntruckBillsBLService {
	public ResultMessage addCenterEntruckBills(myDate date, String TrafficNum, 
			String HallNum, String Vehicle, String DriverName, String ScouterName);
	public String addGoods(String GoodsNum);
	public String deleteGoods(String GoodsNum);
	public long getPrice(String HallNum);
	

}
