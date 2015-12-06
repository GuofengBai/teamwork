package org.businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import org.po.ResultMessage;

public interface SettingAlertBLService {

	/**
	 * 启动警报设置
	 * @param alartLine 警报线
	 * @return 返回设置是否成功
	 */
	public boolean settingAlert(String centerNum, double alertLine) throws RemoteException;
	/**
	 * 得到当前的货物存储线
	 * @param centerNum 中转中心编号
	 * @return
	 * @throws RemoteException
	 */
	public double getAlert(String centerNum) throws RemoteException;
	/**
	 * 入库时检查是否超过警报线
	 * @param centerNum
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage ALERT(String centerNum)  throws RemoteException;
}
