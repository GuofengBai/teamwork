package org.businesslogic.billsbl;

import org.businesslogic.organizationbl.ManagerSettingBL;
import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.businesslogicservice.billsblservice.NewCenterFreightBillsBLService;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.myDate;

public class NewCenterFreightBillsBL implements NewCenterFreightBillsBLService{

	public ResultMessage addCenterFreightBills(myDate date, String FreightNum,
			String tramNum, String StartPlace, String EndPlace, String caseNum,
			String Scoutername) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getPrice(SENDSTYPE send, String StartPlace, String EndPlace) {
		// TODO Auto-generated method stub
		int canshu = 20;
		if(send==SENDSTYPE.SLOW){
			canshu = 400;
		}
		if(send==SENDSTYPE.FAST){
			canshu = 1000;
		}
		ManagerSettingBL managerset = new ManagerSettingBL();
		double price = managerset.getCitiesDistance(StartPlace, EndPlace)*canshu;
		return (long)price;
	}

}
