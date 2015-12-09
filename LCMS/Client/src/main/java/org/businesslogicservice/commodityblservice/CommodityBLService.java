package org.businesslogicservice.commodityblservice;

import org.po.ResultMessage;
import java.rmi.RemoteException;

public interface CommodityBLService {
	boolean Commodityinable = true;
	/**
	 * 
	 * @param centerNum
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addCenter(String centerNum) throws RemoteException;
	/**
	 * 
	 * @param centerNum
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage delCenter(String centerNum) throws RemoteException;
	
	
	
}



