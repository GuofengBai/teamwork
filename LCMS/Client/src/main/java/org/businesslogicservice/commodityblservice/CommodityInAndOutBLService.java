package org.businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import org.po.ComPO;
import org.po.ResultMessage;



public interface CommodityInAndOutBLService {
	/**
	 * 入库
	 * @param Sending 快递单号
	 * @return 返回入库是否成功
	 * @throws RemoteException 
	 */
	public ResultMessage Commodityin(ComPO po) throws RemoteException;
	/**
	 * 出库
	 * @param Sending 快递单号
	 * @return 返回出库是否成功
	 * @throws RemoteException 
	 */
	public ResultMessage Commodityout(ComPO po) throws RemoteException;
}
