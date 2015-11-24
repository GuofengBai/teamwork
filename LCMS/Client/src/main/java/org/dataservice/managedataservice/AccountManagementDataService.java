package org.dataservice.managedataservice;

import java.rmi.RemoteException;

import org.po.BankAccountPO;

public interface AccountManagementDataService {
	public BankAccountPO[] getAccountList ()throws RemoteException;
	
	public void addAccount(String name)throws RemoteException;
	
	public int getBalance(String name)throws RemoteException;
	
	public void delAccount(String name)throws RemoteException;
	
	public void changeName(String name,String newname)throws RemoteException;
	
	public void changeBalance (String name,int change)throws RemoteException;
	
	public BankAccountPO[] search(String namepart)throws RemoteException;
}
