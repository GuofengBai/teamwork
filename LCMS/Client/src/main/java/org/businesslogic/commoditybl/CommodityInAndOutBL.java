package org.businesslogic.commoditybl;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.CommodityInAndOutBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.CommodityPO;

public class CommodityInAndOutBL implements CommodityInAndOutBLService {
	CommodityDataService cds = RMIHelper.getDataFactory().getCommodityData();

	public boolean Commodityin(ComPO po) {
		// TODO Auto-generated method stub

		if (cds.addCom(po).success)
			return true;
		else
			return false;
	}

	public boolean Commodityout(ComPO po) {
		// TODO Auto-generated method stub
		if (cds.delCom(po).success) {
			return true;
		} else
			return false;
	}

}
