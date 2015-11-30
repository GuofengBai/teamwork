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
import org.vo.HCBVO;
import org.vo.StateListVO;

public class NewHallCollectBillsBL implements NewHallCollectBillsBLService{

	public ResultMessage addHallCollectionBills(HCBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallCollectBillsData();
			message=billsData.addBills(new HallCollectionBills(vo.date, vo.idNum, vo.name, vo.total, vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
