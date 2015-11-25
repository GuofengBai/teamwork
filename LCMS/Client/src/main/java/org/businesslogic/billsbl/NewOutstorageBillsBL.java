package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewOutstorageBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.ComPO;
import org.po.InstorageBills;
import org.po.OutstorageBills;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.CommodityVO;

public class NewOutstorageBillsBL implements NewOutstorageBillsBLService{

	public ResultMessage addOutstorageBills(myDate date, String centerNum, String entruckNum, ArrayList<CommodityVO> list) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewOutstorageBillsData();
			message=billsData.addBills(new OutstorageBills(date, centerNum, entruckNum, list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}


}
