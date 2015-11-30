package org.businesslogicservice.commodityblservice;

import org.po.ResultMessage;

public interface SettingAlertBLService {

	/**
	 * 启动警报设置
	 * @param alartLine 警报线
	 * @return 返回设置是否成功
	 */
	public boolean settingAlert(String centerNum,double alertLine);
	public double getAlert(String centerNum);
	public ResultMessage ALERT(String centerNum);
}
