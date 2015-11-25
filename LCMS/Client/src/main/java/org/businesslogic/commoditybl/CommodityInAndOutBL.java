package org.businesslogic.commoditybl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.CommodityInAndOutBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.CommodityPO;

public class CommodityInAndOutBL implements CommodityInAndOutBLService {
	

	public boolean Commodityin(ComPO po) throws RemoteException {
		// TODO Auto-generated method stub
		CommodityDataService cds = RMIHelper.getDataFactory().getCommodityData();
		if (cds.addCom(po).success)
			return true;
		else
			return false;
	}

	public boolean Commodityout(ComPO po) throws RemoteException {
		// TODO Auto-generated method stub
		CommodityDataService cds = RMIHelper.getDataFactory().getCommodityData();
		if (cds.delCom(po).success) {
			return true;
		} else
			return false;
	}

}
