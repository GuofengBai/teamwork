package org.businesslogic.billsbl;

import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.businesslogicservice.billsblservice.NewCenterFreightBillsBLService;
import org.po.ResultMessage;
import org.po.myDate;

public class NewCenterFreightBillsBL implements NewCenterFreightBillsBLService{

	public ResultMessage addCenterFreightBills(myDate date, String FreightNum,
			String tramNum, String StartPlace, String EndPlace, String caseNum,
			String Scoutername) {
		// TODO Auto-generated method stub
		return null;
	}

	public String addGoods(String GoodsNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteGoods(String GoodsNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getPrice(String tramNum, String StartPlace, String EndPlace) {
		// TODO Auto-generated method stub
		return 0;
	}

}
