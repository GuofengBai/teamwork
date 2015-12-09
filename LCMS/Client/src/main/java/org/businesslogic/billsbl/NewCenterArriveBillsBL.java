package org.businesslogic.billsbl;

import java.rmi.RemoteException;


import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewCenterArriveBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

import org.po.CenterArriveBills;
import org.po.EXPRESSSTATE;
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
				if(((SendingBills)sendingBillsData.findBills(po.getNum())).getState()==EXPRESSSTATE.LOCALTOTARGET)
					((SendingBills)sendingBillsData.findBills(po.getNum())).setExpressState(EXPRESSSTATE.TARGETCENTER);
				else
					((SendingBills)sendingBillsData.findBills(po.getNum())).setExpressState(EXPRESSSTATE.LOCALCENTER);						
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


}
