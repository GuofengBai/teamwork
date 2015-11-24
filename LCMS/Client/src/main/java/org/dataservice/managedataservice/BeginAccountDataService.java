package org.dataservice.managedataservice;

import java.rmi.RemoteException;

import org.po.BeginAccountPO;

public interface BeginAccountDataService {
	public void addBeginAccount (BeginAccountPO account)throws RemoteException;
	
	public void Initialize(BeginAccountPO account)throws RemoteException;
	
	public BeginAccountPO getBeginAccount()throws RemoteException;
	
	public void deleteAccount(BeginAccountPO account)throws RemoteException;
	
	
}
