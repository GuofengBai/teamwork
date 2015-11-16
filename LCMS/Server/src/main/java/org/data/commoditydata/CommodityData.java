package org.data.commoditydata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.BillsPO;
import org.po.ComPO;
import org.po.ResultMessage;

public class CommodityData extends UnicastRemoteObject implements CommodityDataService{

	public ArrayList<ComPO> ComList;
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
