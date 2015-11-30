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
import org.vo.CEBVO;
import org.vo.StateListVO;

public class NewCenterEntruckBillsBL implements NewCenterEntruckBillsBLService{

	public ResultMessage addCenterEntruckBills(CEBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterEntruckBillsData();
			message=billsData.addBills(new CenterEntruckBills(vo.date,vo.TrafficNum,vo.HallNum,vo.Vehicle,vo.DriverName,vo.ScouterName,vo.po));
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
