package org.businesslogic.billsbl;

import java.rmi.RemoteException;






import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.organizationdataservice.HallDataService;
import org.po.BillsPO;
import org.po.CenterEntruckBills;
import org.po.CenterFreightBills;
import org.po.ResultMessage;


import org.po.StateListPO;
import org.vo.CEBVO;


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

	public ResultMessage updateCenterEntruckBills(CEBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterEntruckBillsData();
			message=billsData.updateBills(vo.TrafficNum,new CenterEntruckBills(vo.date,vo.TrafficNum,vo.HallNum,vo.Vehicle,vo.DriverName,vo.ScouterName,vo.po));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public String cherk(CEBVO vo) {
		BillsDataService billsData;
		HallDataService hallData;
		if (vo.TrafficNum.equals(""))
			return "信息未填写完整";
		if (vo.HallNum.equals(""))
			return "信息未填写完整";
		if (vo.Vehicle.equals(""))
			return "信息未填写完整";
		if (vo.DriverName.equals(""))
			return "信息未填写完整";
		if (vo.ScouterName.equals(""))
			return "信息未填写完整";
		try {
			hallData=RMIHelper.getDataFactory().getOrganizationDataFactory().getHallData();
			if(hallData.findHall(vo.HallNum)==null){
				return "营业厅不存在";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterEntruckBillsData();
			if(billsData.Used(vo.TrafficNum)){
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
