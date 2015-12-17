package org.businesslogic.billsbl;

import java.rmi.RemoteException;







import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewCenterArriveBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;
import org.po.BillsPO;
import org.po.CenterArriveBills;
import org.po.CenterFreightBills;
import org.po.EXPRESSSTATE;
import org.po.HallEntruckBills;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.StateListPO;
import org.vo.CABVO;

public class NewCenterArriveBillsBL implements NewCenterArriveBillsBLService{

	public ResultMessage addCenterArriveBills(CABVO vo){
		// TODO Auto-generated method stub
		BillsDataService billsData;
		NewSendingBillsDataService sendingBillsData;
		ResultMessage message=null;
		try {
			billsData = RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterArriveBillsData();
			sendingBillsData = RMIHelper.getDataFactory().getBillsDataFactory().getNewSendingBillsData();
			message=billsData.addBills(new CenterArriveBills(vo.date,vo.FreightNum,vo.CenterNum,vo.po));
			for(StateListPO po:vo.po){
				if(((SendingBills)sendingBillsData.findBills(po.getNum())).getState()==EXPRESSSTATE.LOCALTOTARGET){
					((NewSendingBillsDataService)sendingBillsData).updateExpressState(po.getNum(), EXPRESSSTATE.TARGETCENTER);
				}				
				else{
					((NewSendingBillsDataService)sendingBillsData).updateExpressState(po.getNum(), EXPRESSSTATE.LOCALCENTER);
					System.out.println("yes");
				}						
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return message;
	}

	public ResultMessage updateCenterArriveBills(CABVO vo) {
		// TODO Auto-generated method stub
		BillsDataService billsData;
		ResultMessage message=null;
		try {
			billsData = RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterArriveBillsData();
			message=billsData.updateBills(vo.CenterNum, new CenterArriveBills(vo.date,vo.FreightNum,vo.CenterNum,vo.po));	
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return message;
	}

	public String cherk(CABVO vo) {
		BillsDataService billsData;
		try {
			billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterArriveBillsData();
			if(billsData.Used(vo.CenterNum)){
				return "单据号已存在";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

	public boolean search(String CABNum, String GoodNum) {
		BillsDataService billsData;
		if(CABNum.charAt(3)=='0'){
			try {
				billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterFreightBillsData();
				BillsPO po = billsData.findBills(CABNum);
				if(((CenterFreightBills)po).getpo() == null){
					return false;
				}
				for(StateListPO list:((CenterFreightBills)po).getpo()){
					if(list.getNum().equals(GoodNum)){
						return true;
					}
				}				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(CABNum.charAt(3)=='1'){
			try {
				billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallEntruckBillsData();
				BillsPO po = billsData.findBills(CABNum);
				for(StateListPO list:((HallEntruckBills)po).getlist()){
					if(list.getNum().equals(GoodNum)){
						return true;
					}
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}


}
