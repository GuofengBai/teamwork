package org.data.commoditydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.commoditydataservice.CommodityDataService;

public class CommodityData extends UnicastRemoteObject implements CommodityDataService{

	protected CommodityData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
