package org.Client;

import org.businesslogic.commoditybl.CommodityInAndOutBL;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;

public class MockCommodityInAndOutBL extends CommodityInAndOutBL {
	public boolean Commodityin(ComPO po) {
		//CommodityDataService cds = RMIHelper.getDataFactory()
		//		.getCommodityData();
		//cds.addCom(po);
		return true;

	}

	public boolean Commodityout(ComPO po) {
		// TODO Auto-generated method stub
		//CommodityDataService cds = RMIHelper.getDataFactory()
		//		.getCommodityData();
		//cds.delCom(po);
		return true;
	}
}
