package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.MockBillsDataService;
import org.Client.MockCommodityInAndOutBL;
import org.Client.RMIHelper;
import org.businesslogic.commoditybl.CommodityInAndOutBL;
import org.businesslogicservice.billsblservice.NewInstorageBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.ComPO;
import org.po.CommodityPO;
import org.po.HallCollectionBills;
import org.po.InstorageBills;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.CommodityVO;

public class NewInstorageBillsBL implements NewInstorageBillsBLService {

	public ResultMessage newInstorageBill(myDate date,String idNum, String centerNum, ArrayList<CommodityVO> list) {
		// TODO Auto-generated method stub
		//BillsDataService bds=RMIHelper.getDataFactory().getBillsData();
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewInstorageBillsData();
			message=billsData.addBills(new InstorageBills(date,idNum, centerNum, list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
