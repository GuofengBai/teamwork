package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.myDate;

public interface NewCenterFreightBillsBLService {
	public ResultMessage addCenterFreightBills(myDate date, String FreightNum, 
			String tramNum, String StartPlace, String EndPlace, String caseNum, String Scoutername);
	public String addGoods(String GoodsNum);
	public String deleteGoods(String GoodsNum);
	public long getPrice(String tramNum, String StartPlace, String EndPlace);

}
