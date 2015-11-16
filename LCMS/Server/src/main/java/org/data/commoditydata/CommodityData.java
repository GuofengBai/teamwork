package org.data.commoditydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.ResultMessage;

public class CommodityData extends UnicastRemoteObject implements CommodityDataService{

	protected CommodityData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage addCom(ComPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delCom(ComPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ComPO findCom(String GoodsNum) {
		// TODO Auto-generated method stub
		return null;
	}


}
