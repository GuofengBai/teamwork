package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewCenterArriveBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.CenterArriveBills;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.myDate;
import org.vo.StateListVO;

public class NewCenterArriveBillsBL implements NewCenterArriveBillsBLService{

	public ResultMessage addCenterArriveBills(myDate date, String FreightNum,
			String CenterNum, ArrayList<StateListVO> vo) {
		// TODO Auto-generated method stub
		BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterArriveBillsData();
		ResultMessage message=null;
		try {
			message=billsData.addBills(new CenterArriveBills(date,FreightNum,CenterNum,vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}


}
