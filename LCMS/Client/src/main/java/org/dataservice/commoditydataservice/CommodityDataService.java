package org.dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.AlertPO;
import org.po.ComPO;
import org.po.ResultMessage;

public interface CommodityDataService extends Remote {

	public ResultMessage addCom(ComPO po) throws RemoteException;

	/**
	 * 删除ComPO
	 * 
	 * @return ResultMessage
	 */
	public ResultMessage delCom(ComPO po) throws RemoteException;

	/**
	 * 查找DriverPO
	 * 
	 * @param GoodsNum
	 *            托运单号
	 * @return ResultMessage
	 */
	public ComPO findCom(String GoodsNum) throws RemoteException;

	/**
	 * 得到当前中转中心所有货物的列表
	 * 
	 * @param centerNum
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ComPO> getAllCom(String centerNum) throws RemoteException;

	/**
	 * 设置警报线
	 * 
	 * @param centerNum
	 * @param line
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setAlert(String centerNum, double line)
			throws RemoteException;

	/**
	 * 得到当前货物线
	 * 
	 * @param centerNum
	 * @return
	 * @throws RemoteException
	 */
	public AlertPO getAlert(String centerNum) throws RemoteException;

	/**
	 * 中转中心所有货物数量
	 * 
	 * @param centerNum
	 * @return
	 * @throws RemoteException
	 */
	public int getComSize(String centerNum) throws RemoteException;

	/**
	 * 新增中转中心
	 * 
	 * @param centerNum
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addNewCity(String centerNum) throws RemoteException;

	/**
	 * 删除中转中心
	 * 
	 * @param centerNum
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage delNewCity(String centerNum) throws RemoteException;
}
