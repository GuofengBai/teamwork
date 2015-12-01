package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogic.organizationbl.ManagerSettingBL;
import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.businesslogicservice.billsblservice.NewCenterFreightBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;
import org.po.CenterFreightBills;
import org.po.EXPRESSSTATE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.SendingBills;
import org.po.StateListPO;
import org.po.myDate;
import org.vo.CFBVO;
import org.vo.StateListVO;

public class NewCenterFreightBillsBL implements NewCenterFreightBillsBLService{

	public ResultMessage addCenterFreightBills(CFBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		NewSendingBillsDataService sendingBillsData;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterFreightBillsData();
			sendingBillsData = RMIHelper.getDataFactory().getBillsDataFactory().getNewSendingBillsData();
			message=billsData.addBills(new CenterFreightBills(vo.date,vo.FreightNum,
					vo.tramNum, vo.StartPlace, vo.EndPlace, vo.caseNum,
					vo.Scoutername, vo.price, vo.send, vo.po));
			for(StateListPO po:vo.po){
				((SendingBills)sendingBillsData.findBills(po.getNum())).setExpressState(EXPRESSSTATE.LOCALTOTARGET);				
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public long getPrice(SENDSTYPE send, String StartPlace, String EndPlace) {
		// TODO Auto-generated method stub
		int canshu = 20;
		if(send==SENDSTYPE.SLOW){
			canshu = 400;
		}
		if(send==SENDSTYPE.FAST){
			canshu = 1000;
		}
		ManagerSettingBL managerset = new ManagerSettingBL();
		double price = managerset.getCitiesDistance(StartPlace, EndPlace)*canshu;
		return (long)price;
	}

	public ResultMessage updateCenterFreightBills(CFBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterFreightBillsData();
			message=billsData.updateBills(vo.FreightNum, new CenterFreightBills(vo.date,vo.FreightNum,
					vo.tramNum, vo.StartPlace, vo.EndPlace, vo.caseNum,
					vo.Scoutername, vo.price, vo.send, vo.po));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
