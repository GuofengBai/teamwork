package org.businesslogic.billsbl;

import java.rmi.RemoteException;



import org.Client.RMIHelper;
import org.businesslogic.organizationbl.ManagerSettingBL;
import org.businesslogicservice.billsblservice.NewCenterFreightBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;
import org.po.CenterFreightBills;
import org.po.EXPRESSSTATE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.StateListPO;
import org.po.TRANSPORTATION;
import org.vo.CFBVO;


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
				((NewSendingBillsDataService)sendingBillsData).updateExpressState(po.getNum(), EXPRESSSTATE.LOCALTOTARGET);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public long getPrice(SENDSTYPE send, String StartPlace, String EndPlace) {
		// TODO Auto-generated method stub
		TRANSPORTATION type = TRANSPORTATION.CAR;
		if(send==SENDSTYPE.SLOW){
			type = TRANSPORTATION.TRAIN;
		}
		if(send==SENDSTYPE.FAST){
			type = TRANSPORTATION.PLANE;
		}
		ManagerSettingBL managerset = new ManagerSettingBL();
		double price = managerset.getCityDistance(StartPlace, EndPlace)*managerset.getTransFee(type);
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

	public String cherk(CFBVO vo) {
		BillsDataService billsData;
		try {
			billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterFreightBillsData();
			if(billsData.Used(vo.FreightNum)){
				return "单据号已存在";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

}
