package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.BankAccountPO;
import org.po.ResultMessage;

public interface AccountManagementDataService extends Remote{
	public ArrayList<BankAccountPO> getAccountList () throws RemoteException;
	
	public ResultMessage addAccount(BankAccountPO account) throws RemoteException;
	
	public int getBalance(String name) throws RemoteException;
	
	public ResultMessage delAccount(String name) throws RemoteException;
	
	public ResultMessage changeName(String name,String newname) throws RemoteException;
	
	public ResultMessage changeBalance (String name,int change) throws RemoteException;
	
	public ArrayList<BankAccountPO> search(String namepart) throws RemoteException;
}
