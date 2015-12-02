package org.dataservice.organizationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.HallPO;
import org.po.ResultMessage;

public interface HallDataService extends Remote{

	/**
	 * 添加HallPO
	 * @return ResultMessage
	 */
	public ResultMessage addHall(HallPO po)throws RemoteException;
	/**
	 * 删除HallPO
	 * @return ResultMessage
	 */
	public ResultMessage delHall(String HallNum)throws RemoteException;
	/**
	 * 查找HallPO
	 * @param HallNum 营业厅编号
	 * @return HallPO
	 */
	public HallPO findHall(String HallNum)throws RemoteException;
	/**
	 * 更新hall
	 * @param po hall
	 * @return ResultMessage
	 */
	public ResultMessage updateHall(HallPO po)throws RemoteException;
	/**
	 * 返回所有Hall
	 * @return ArrayList
	 */
	public ArrayList<HallPO> getAll()throws RemoteException;
	
	
}
