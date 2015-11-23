package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewCenterArriveBillsBLService;
import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewCenterEntruckBillsDataService;
import org.po.CenterEntruckBills;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.myDate;
import org.vo.StateListVO;

public class NewCenterEntruckBillsBL implements NewCenterEntruckBillsBLService{

	public ResultMessage addCenterEntruckBills(myDate date, String TrafficNum,
			String HallNum, String Vehicle, String DriverName,
			String ScouterName, ArrayList<StateListVO> vo) {
		// TODO Auto-generated method stub
		BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterEntruckBillsData();
		ResultMessage message=null;
		try {
			message=billsData.addBills(new CenterEntruckBills(date,TrafficNum,HallNum,Vehicle,DriverName,ScouterName,vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public long getPrice(String HallNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
