package org.data.billsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.billsdataservice.BillsDataService;
import org.po.BILLSTYPE;
import org.po.BillsPO;
import org.po.ResultMessage;
import org.po.myDate;

public class BillsData extends UnicastRemoteObject implements BillsDataService{

	public BillsData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage addBills(BillsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public BillsPO findBills(int BillNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteBills(int BillNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateBills(int BillNum, BillsPO bill)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage examine(int BillNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public long getUnexaminedBillsNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<BillsPO> getUnexaminedBills() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BillsPO> getByDate(myDate date1, myDate date2) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage save() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
