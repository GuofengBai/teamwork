package org.dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.AlertPO;
import org.po.ComPO;
import org.po.ResultMessage;


public interface CommodityDataService extends Remote{

	public ResultMessage addCom(ComPO po)throws RemoteException;
     /**
	 * 删除ComPO
	 * @return ResultMessage
	 */
	public ResultMessage delCom(ComPO po)throws RemoteException;
	/**
	 * 查找DriverPO
	 * @param GoodsNum 托运单号
	 * @return ResultMessage
	 */
	public ComPO findCom(String GoodsNum)throws RemoteException;
	public ArrayList<ComPO> getAllCom(String centerNum)throws RemoteException;
	public ResultMessage setAlert(String centerNum,double line) throws RemoteException;
	public AlertPO getAlert(String centerNum) throws RemoteException;
	public int getComSize(String centerNum) throws RemoteException;
}
