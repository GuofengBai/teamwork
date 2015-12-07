package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.BeginAccountPO;
import org.po.ResultMessage;

public interface BeginAccountDataService extends Remote{
	
	/**
	 * 新建期初账单
	 * 
	 * @param BeginAccountPO
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addBeginAccount (BeginAccountPO account) throws RemoteException;
	
	/**
	 * 初始化期初数据
	 * 
	 * @param BeginAccountPO
	 * @return 
	 * @throws RemoteException
	 */
	public void Initialize(BeginAccountPO account) throws RemoteException;
	
	/**
	 * 获取期初账单列表
	 * 
	 * @return ArrayList<BeginAccountPO>
	 * @throws RemoteException
	 */
	public ArrayList<BeginAccountPO> getBeginAccountList() throws RemoteException;
	
	/**
	 * 获取当前期初账单
	 * 
	 * @return BeginAccountPO
	 * @throws RemoteException
	 */
	public BeginAccountPO getBeginAccount() throws RemoteException;
	
	/**
	 * 删除账单 
	 * 
	 * @param BeginAccountPO
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage deleteAccount(BeginAccountPO account) throws RemoteException;
	
	
}
