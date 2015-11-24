package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogic.organizationbl.ManagerSettingBL;
import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.businesslogicservice.billsblservice.NewCenterFreightBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.CenterFreightBills;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.SendingBills;
import org.po.myDate;
import org.vo.StateListVO;

public class NewCenterFreightBillsBL implements NewCenterFreightBillsBLService{

	public ResultMessage addCenterFreightBills(myDate date, String FreightNum,
			String tramNum, String StartPlace, String EndPlace, String caseNum,
			String Scoutername, long price, SENDSTYPE send, ArrayList<StateListVO> vo) {
		// TODO Auto-generated method stub
		BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterFreightBillsData();
		ResultMessage message=null;
		try {
			message=billsData.addBills(new CenterFreightBills(date,FreightNum,
					tramNum, StartPlace, EndPlace, caseNum,
					Scoutername, price, send, vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
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
