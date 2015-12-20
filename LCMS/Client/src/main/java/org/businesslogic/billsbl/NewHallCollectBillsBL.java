package org.businesslogic.billsbl;

import java.rmi.RemoteException;




import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewHallCollectBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.HallCollectionBills;
import org.po.ResultMessage;
import org.vo.HCBVO;


public class NewHallCollectBillsBL implements NewHallCollectBillsBLService{

	public ResultMessage addHallCollectionBills(HCBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallCollectBillsData();
			message=billsData.addBills(new HallCollectionBills(vo.date, vo.idNum, vo.name, vo.total, vo.list));
			
		//	AccountManagementBLService ambl=BLFactory.getAccountManagementBL();
		//	ambl.changeBalance("", Long.parseLong(vo.total));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public ResultMessage updateHallCollectionBills(HCBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallCollectBillsData();
			message=billsData.updateBills(vo.idNum, new HallCollectionBills(vo.date, vo.idNum, vo.name, vo.total, vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public String cherk(HCBVO vo) {
		BillsDataService billsData;
		if (vo.idNum.equals(""))
			return "信息未填写完整";
		if (vo.name.equals(""))
			return "信息未填写完整";
		try {
			billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallCollectBillsData();
			if(billsData.Used(vo.idNum)){
				return "单据号已存在";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

	public String search(String GoodNum) {
		// TODO Auto-generated method stub
		BillsDataService billsData;
		try {
			billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewSendingBillsData();
			if(!billsData.Used(GoodNum)){
				return "托运单号不存在";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
