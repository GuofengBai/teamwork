package org.businesslogic.commoditybl;

import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.DistrictChangeBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;

public class DistrictChangeBL implements DistrictChangeBLService{
	CommodityDataService cds=RMIHelper.getDataFactory().getCommodityData();
	
	public ComPO change(String from, String to) {
		// TODO Auto-generated method stub
		ArrayList<ComPO> list=cds.getAllCom();
		
		
		return null;
		
	}

}
