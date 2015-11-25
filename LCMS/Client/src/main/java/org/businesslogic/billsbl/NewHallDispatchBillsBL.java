package org.businesslogic.billsbl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewHallDispatchBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.HallCollectionBills;
import org.po.HallDispatchBills;
import org.po.ResultMessage;
import org.po.myDate;

public class NewHallDispatchBillsBL implements NewHallDispatchBillsBLService{

	public ResultMessage newHallDispatchBill(myDate date, String name,
			String GoodsNum) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallDispatchBillsData();
			message=billsData.addBills(new HallDispatchBills(date, name, GoodsNum));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
