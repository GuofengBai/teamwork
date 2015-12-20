package org.businesslogic.billsbl;

import java.rmi.RemoteException;




import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewHallArriveBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;
import org.po.EXPRESSSTATE;
import org.po.HallArrivingBills;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.StateListPO;


import org.vo.HABVO;


public class NewHallArriveBillsBL implements NewHallArriveBillsBLService{

	public ResultMessage addHallArriveBills(HABVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		NewSendingBillsDataService sendingBillsData;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallArriveBillsData();
			message=billsData.addBills(new HallArrivingBills(vo.date,vo.idNum,vo.startPlace,vo.entruckNum,vo.list));
			sendingBillsData = RMIHelper.getDataFactory().getBillsDataFactory().getNewSendingBillsData();
			for(StateListPO po:vo.list){
				if(((SendingBills)sendingBillsData.findBills(po.getNum())).getState()==EXPRESSSTATE.TARGETCENTER)
					((NewSendingBillsDataService)sendingBillsData).updateExpressState(po.getNum(), EXPRESSSTATE.TARGETHALL);				
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public ResultMessage updateHallArriveBills(HABVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallArriveBillsData();
			message=billsData.updateBills(vo.idNum, new HallArrivingBills(vo.date,vo.idNum,vo.startPlace,vo.entruckNum,vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public String cherk(HABVO vo) {
		if (vo.idNum.equals(""))
			return "信息未填写完整";
		if (vo.startPlace.equals(""))
			return "信息未填写完整";
		if (vo.entruckNum.equals(""))
			return "信息未填写完整";
		BillsDataService billsData;
		try {
			billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterEntruckBillsData();
			if(!billsData.Used(vo.entruckNum)){
				return "装车单不存在";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallArriveBillsData();
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
