package org.businesslogic.billsbl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewCenterArriveBillsBLService;
import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.CenterEntruckBills;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.myDate;

public class NewCenterEntruckBillsBL implements NewCenterEntruckBillsBLService{

	public ResultMessage addCenterEntruckBills(myDate date, String TrafficNum,
			String HallNum, String Vehicle, String DriverName,
			String ScouterName) {
		// TODO Auto-generated method stub
		BillsDataService billsData=RMIHelper.getDataFactory().getBillsData();
		ResultMessage message=null;
		try {
			message=billsData.addBills(new CenterEntruckBills());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public String addGoods(String GoodsNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteGoods(String GoodsNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getPrice(String HallNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
