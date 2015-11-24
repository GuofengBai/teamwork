package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewHallCollectBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.CenterFreightBills;
import org.po.HallCollectionBills;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.StateListVO;

public class NewHallCollectBillsBL implements NewHallCollectBillsBLService{

	public ResultMessage addHallCollectionBills(myDate date, String name, String total, ArrayList<StateListVO> list) {
		// TODO Auto-generated method stub
		BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallCollectBillsData();
		ResultMessage message=null;
		try {
			message=billsData.addBills(new HallCollectionBills(date, name, total, list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
