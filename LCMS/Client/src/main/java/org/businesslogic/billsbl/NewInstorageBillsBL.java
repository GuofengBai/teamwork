package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewInstorageBillsBLService;
import org.businesslogicservice.commodityblservice.CommodityInAndOutBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.InstorageBills;
import org.po.ResultMessage;
import org.vo.IBVO;

public class NewInstorageBillsBL implements NewInstorageBillsBLService {

	public ResultMessage newInstorageBill(IBVO vo) {
		// TODO Auto-generated method stub
		// BillsDataService bds=RMIHelper.getDataFactory().getBillsData();
		ResultMessage message = null;
		try {
			BillsDataService billsData = RMIHelper.getDataFactory()
					.getBillsDataFactory().getNewInstorageBillsData();
			message = billsData.addBills(new InstorageBills(vo.date, vo.idNum,
					vo.centerNum, vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public void addCommodity(ArrayList<ComPO> list) {
		CommodityInAndOutBLService commodityInAndOutBL = BLFactory
				.getCommodityInAndOutBL();
		for (int i = 0; i < list.size(); i++) {
			try {
				commodityInAndOutBL.Commodityin(list.get(i));
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public ResultMessage updateInstorageBill(IBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message = null;
		try {
			BillsDataService billsData = RMIHelper.getDataFactory()
					.getBillsDataFactory().getNewInstorageBillsData();
			message = billsData.updateBills(vo.idNum, new InstorageBills(
					vo.date, vo.idNum, vo.centerNum, vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public String cherk(IBVO vo) {
		BillsDataService billsData;
		CommodityDataService ComData;
		try {
			billsData = RMIHelper.getDataFactory().getBillsDataFactory()
					.getNewInstorageBillsData();
			ComData = RMIHelper.getDataFactory().getCommodityData();
			if (billsData.Used(vo.idNum)) {
				return "单据号已存在";
			}
			if(ComData.getComSize(vo.centerNum)==-1)
				return "中转中心不存在";
			//for (ComPO po : vo.list){
				//if(!ComData.findCom(po.getGoodsNum()).equals("")){
				//	return "";
				//}
				//if(ComData.findCom(po.getGoodsNum()).getcenterNum().equals(vo.centerNum)){
					return "";
				//}
				//return "托运单已经使用过";
			//}
				
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

}
