package org.dataservice.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.billsdataservice.BillsDataService;
import org.po.BillsPO;
import org.po.ResultMessage;

public class BillsDataServiceSerializableFileImpl extends UnicastRemoteObject implements BillsDataService{

	public BillsDataServiceSerializableFileImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage addBills(BillsPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage findBills(int BillNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteBills(int BillNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateBills(int BillNum, BillsPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
