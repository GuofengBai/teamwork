package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewOutstorageBillsBLService;
import org.businesslogicservice.commodityblservice.CommodityInAndOutBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.InstorageBills;
import org.po.OutstorageBills;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.CommodityVO;
import org.vo.OBVO;

public class NewOutstorageBillsBL implements NewOutstorageBillsBLService{

	public ResultMessage addOutstorageBills(OBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewOutstorageBillsData();
			message=billsData.addBills(new OutstorageBills(vo.date, vo.centerNum, vo.entruckNum, vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	public void deleteCommodity(ArrayList<ComPO> list){
		CommodityInAndOutBLService commodityInAndOutBL = BLFactory.getCommodityInAndOutBL();
		
		for(int i=0;i<list.size();i++){
			try {
				commodityInAndOutBL.Commodityout(list.get(i));
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public CommodityVO creatVO(String goodNum) {
		// TODO Auto-generated method stub		
		ComPO cpo = creatPO(goodNum);
		CommodityVO cvo = new CommodityVO(cpo.getGoodsNum(),cpo.getinDate(),cpo.getplace(),cpo.LocationNum(),cpo.getArea(),cpo.getcenterNum());
		return cvo;
	}
	public ComPO creatPO(String goodNum) {
		// TODO Auto-generated method stub
		CommodityDataService service=null;
		ComPO cpo = null;
		try {
			service = RMIHelper.getDataFactory().getCommodityData();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cpo = service.findCom(goodNum);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return cpo;
	}
	public ResultMessage updateOutstorageBills(OBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewOutstorageBillsData();
			message=billsData.updateBills(vo.centerNum, new OutstorageBills(vo.date, vo.centerNum, vo.entruckNum, vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}


}
