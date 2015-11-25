package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewHallEntruckBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.HallCollectionBills;
import org.po.HallEntruckBills;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.StateListVO;

public class NewHallEntruckBillsBL implements NewHallEntruckBillsBLService{
	public ResultMessage addHallEntruckBills(myDate date, String entruckNum,
			String hallNum, String aimNum, String carNum, String driverName, ArrayList<StateListVO> list) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallEntruckBillsData();
			message=billsData.addBills(new HallEntruckBills(date, entruckNum, hallNum, aimNum, carNum, driverName, list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
