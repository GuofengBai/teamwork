package org.dataservice.organizationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.po.CityAndDistancePO;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.TRANSPORTATION;

public interface ManagerSettingDataService extends Remote{
	
	/**
	 * 返回CityAndDistancePO，包含一个String[],一个double[]
	 * @return CityAndDistancePO
	 * @throws RemoteException
	 */
	public CityAndDistancePO getCityAndDistance()throws RemoteException;
	
	/**
	 * 根据传来的值修改CityAndDistancePO，并保存修改
	 * @param po
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage setCityAndDistance(CityAndDistancePO po)throws RemoteException;
	
	/**
	 * 根据快递类型，返回运费基准价
	 * @param type（包括SLOW,NORMAL,FAST，分别对应经济，标准，次晨特快）
	 * @return double,代表运费基准价
	 * @throws RemoteException
	 */
	public double getExpressFee(SENDSTYPE type)throws RemoteException;
	
	/**
	 * 设置不同快递方式的运费基准价
	 * @param type
	 * @param fee
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setExpressFee(SENDSTYPE type,double fee)throws RemoteException;
	
	/**
	 * 根据载具类型，返回运费基准价
	 * @param type(汽运，火车运，航运)
	 * @return
	 * @throws RemoteException
	 */
	public double getTransFee(TRANSPORTATION type)throws RemoteException;
	
	/**
	 * 设置不同载具方式的运费基准价
	 * @param type
	 * @param fee
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setTransFee(TRANSPORTATION type,double fee)throws RemoteException;
	
	

}
