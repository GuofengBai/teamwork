package org.data.billsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.billsdataservice.BillsDataService;
import org.po.BILLSTYPE;
import org.po.BillsPO;
import org.po.ResultMessage;

public class BillsData extends UnicastRemoteObject implements BillsDataService{

	public BillsData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage addBills(BillsPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateBills(int BillNum, BillsPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage examine(BillsPO bill) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillsPO findBills(int BillNum, BILLSTYPE type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteBills(int BillNum, BILLSTYPE type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
