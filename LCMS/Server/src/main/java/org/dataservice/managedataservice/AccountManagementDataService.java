package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.BankAccountPO;
import org.po.ResultMessage;

public interface AccountManagementDataService extends Remote{
	
	/**
	 * 获取账户列表
	 * 
	 * @return ArrayList<BankAccountPO>
	 * @throws RemoteException
	 */
	public ArrayList<BankAccountPO> getAccountList () throws RemoteException;
	
	/**
	 * 新增账户
	 * 
	 * @param BankAccountPO
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addAccount(BankAccountPO account) throws RemoteException;
	
	/**
	 * 获取指定账户余额
	 * 
	 * @param String
	 * @return long
	 * @throws RemoteException
	 */
	public long getBalance(String name) throws RemoteException;
	
	/**
	 * 删除指定账户
	 * 
	 * @param String
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage delAccount(String name) throws RemoteException;
	
	/**
	 * 修改账户名
	 * 
	 * @param String
	 * @param String
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage changeName(String name,String newname) throws RemoteException;
	
	/**
	 * 修改余额
	 * 
	 * @param String
	 * @param long
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage changeBalance (String name,long change) throws RemoteException;
	
	/**
	 * 关键字查找
	 * 
	 * @param String
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ArrayList<BankAccountPO> search(String namepart) throws RemoteException;
}
