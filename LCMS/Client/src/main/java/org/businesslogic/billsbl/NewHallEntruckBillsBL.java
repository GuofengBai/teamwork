package org.businesslogic.billsbl;

import java.rmi.RemoteException;



import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewHallEntruckBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.HallEntruckBills;
import org.po.ResultMessage;
import org.vo.HEBVO;


public class NewHallEntruckBillsBL implements NewHallEntruckBillsBLService{
	public ResultMessage addHallEntruckBills(HEBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallEntruckBillsData();
			message=billsData.addBills(new HallEntruckBills(vo.date, vo.entruckNum, vo.hallNum, vo.aimNum, vo.carNum, vo.driverName, vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public ResultMessage updateHallEntruckBills(HEBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallEntruckBillsData();
			message = billsData.updateBills(vo.entruckNum,
					new HallEntruckBills(vo.date, vo.entruckNum, vo.hallNum,
							vo.aimNum, vo.carNum, vo.driverName, vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public String cherk(HEBVO vo) {
		BillsDataService billsData;
		try {
			billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallEntruckBillsData();
			if(billsData.Used(vo.entruckNum)){
				return "单据号已存在";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

}
