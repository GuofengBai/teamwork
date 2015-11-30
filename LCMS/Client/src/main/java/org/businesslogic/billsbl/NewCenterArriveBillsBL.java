package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewCenterArriveBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.BillsPO;
import org.po.CenterArriveBills;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.StateListPO;
import org.po.myDate;
import org.vo.StateListVO;

public class NewCenterArriveBillsBL implements NewCenterArriveBillsBLService{

	public ResultMessage addCenterArriveBills(myDate date, String FreightNum,
			String CenterNum, ArrayList<StateListPO> po){
		// TODO Auto-generated method stub
		BillsDataService billsData;
		ResultMessage message=null;
		try {
			billsData = RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterArriveBillsData();
			if(billsData==null){
				System.out.println("获取失败");
			}
			message=billsData.addBills(new CenterArriveBills(date,FreightNum,CenterNum,po));
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return message;
	}


}
