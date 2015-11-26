package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.BeginAccountPO;
import org.po.ResultMessage;

public interface BeginAccountDataService extends Remote{
	public ResultMessage addBeginAccount (BeginAccountPO account) throws RemoteException;
	
	public void Initialize(BeginAccountPO account) throws RemoteException;
	
	public ArrayList<BeginAccountPO> getBeginAccountList() throws RemoteException;
	
	public BeginAccountPO getBeginAccount() throws RemoteException;
	
	public ResultMessage deleteAccount(BeginAccountPO account) throws RemoteException;
	
	
}
