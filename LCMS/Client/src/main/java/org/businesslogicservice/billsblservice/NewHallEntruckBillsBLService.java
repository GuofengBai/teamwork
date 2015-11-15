package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.myDate;

public interface NewHallEntruckBillsBLService {

	public ResultMessage newHallEntruckBill(myDate date, String TrafficNum, String HallNum, String DestyNum, String Drivername, String tramNum);

	public String[] addGoods(String GoodsNum);

	public String deleteGoods(String GoodsNum);

}
