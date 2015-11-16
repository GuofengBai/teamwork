package org.businesslogic.billsbl;

import java.rmi.RemoteException;

import org.Client.MockCommodityInAndOutBL;
import org.Client.RMIHelper;
import org.businesslogic.commoditybl.CommodityInAndOutBL;
import org.businesslogicservice.billsblservice.NewInstorageBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.ComPO;
import org.po.CommodityPO;
import org.po.InstorageBills;
import org.po.ResultMessage;
import org.po.myDate;

public class NewInstorageBillsBL implements NewInstorageBillsBLService {

	public ResultMessage newInstorageBill(myDate date, String GoodsNum,
			String Destination, String Location) {
		// TODO Auto-generated method stub
		BillsDataService bds=RMIHelper.getDataFactory().getBillsData();
		InstorageBills ib = new InstorageBills();
		ib.setGoodsNum(GoodsNum);
		ib.setDate(date);
		ib.setLocationNum(Location);
		ib.setPlace(Destination);
		ResultMessage rm =null;
		String[] result=null;
		try {
			if(bds.addBills(ib).success){
				return rm=new ResultMessage(true,result);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rm;
	}

	public ComPO addGoods(String GoodsNum, myDate inDate, String place,
			String LocationNum) {
		// TODO Auto-generated method stub
		MockCommodityInAndOutBL mciaobl=new MockCommodityInAndOutBL();
		CommodityInAndOutBL ciaobl=new CommodityInAndOutBL();
		ComPO po=new ComPO(GoodsNum,inDate,place,LocationNum);
		if(mciaobl.Commodityin(po)){
			return po;
		}
		return null;
	}

	public ComPO deleteGoods(String GoodsNum, myDate inDate, String place,
			String LocationNum) {
		// TODO Auto-generated method stub
		MockCommodityInAndOutBL mciaobl=new MockCommodityInAndOutBL();
		CommodityInAndOutBL ciaobl=new CommodityInAndOutBL();
		ComPO po=new ComPO(GoodsNum,inDate,place,LocationNum);
		if(mciaobl.Commodityout(po)){
			return po;
		}
		return null;
	}

}
