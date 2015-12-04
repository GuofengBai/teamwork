package org.dataservice.organizationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.CenterPO;
import org.po.HallPO;
import org.po.ResultMessage;

public interface CenterDataService extends Remote{

	/**
	 * 添加CenterPO
	 * @return ResultMessage
	 */
	public ResultMessage addCenter(CenterPO po)throws RemoteException;
	/**
	 * 删除CenterPO
	 * @return ResultMessage
	 */
	public ResultMessage delCenter(String CenterNum)throws RemoteException;
	/**
	 * 查找CenterPO
	 * @param CenterNum 中转中心编号
	 * @return CenterPO
	 */
	public CenterPO findCenter(String CenterNum)throws RemoteException;
	/**
	 * 更新Center
	 * @param po center
	 * @return ResultMessage
	 */
	public ResultMessage updateCenter(CenterPO po)throws RemoteException;
	/**
	 * 返回所有Center
	 * @return ArrayList
	 */
	public ArrayList<CenterPO> getAll()throws RemoteException;
	
}
