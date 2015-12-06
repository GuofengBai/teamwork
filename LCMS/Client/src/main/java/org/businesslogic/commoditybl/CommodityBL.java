package org.businesslogic.commoditybl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.CommodityBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.ResultMessage;
import org.po.myDate;

public class CommodityBL implements CommodityBLService {
	/**
	 * 新增城市中转中心和删除城市中转中心的接口实现
	 * 
	 * @throws RemoteException
	 */
	private CommodityDataService cds;

	public CommodityBL() throws RemoteException {
		cds = RMIHelper.getDataFactory().getCommodityData();
	}

	/**
	 * 新增
	 */
	public ResultMessage addCenter(String centerNum) throws RemoteException {
		ResultMessage re = cds.addNewCity(centerNum);
		return re;
	}

	/**
	 * 删除
	 */
	public ResultMessage delCenter(String centerNum) throws RemoteException {
		ResultMessage re = cds.delNewCity(centerNum);
		return re;
	}

}
