package org.dataservice.staffdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.po.ResultMessage;
import org.po.StaffPO;

public interface StaffDataService extends Remote{
	
    public ResultMessage add(StaffPO po)throws RemoteException;
	
	public ResultMessage remove(String num)throws RemoteException;
	
	public ResultMessage update(StaffPO po)throws RemoteException;
	
	public StaffPO find(String num)throws RemoteException;
	
	public ArrayList<StaffPO> getAll()throws RemoteException;
	
	public Vector<Vector<String>> getAllStaffInfo()throws RemoteException;

}
