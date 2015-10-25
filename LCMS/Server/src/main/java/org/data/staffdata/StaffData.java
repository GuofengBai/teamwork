package org.data.staffdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.staffdataservice.StaffDataService;
import org.po.ResultMessage;
import org.po.StaffPO;

public class StaffData extends UnicastRemoteObject implements StaffDataService{

	protected StaffData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage add(StaffPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage remove(StaffPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(StaffPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffPO find(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<StaffPO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
