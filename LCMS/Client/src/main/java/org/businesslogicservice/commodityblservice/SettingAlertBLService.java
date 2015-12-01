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
	public double getAlert(String centerNum) throws RemoteException;
	public ResultMessage ALERT(String centerNum)  throws RemoteException;
}
