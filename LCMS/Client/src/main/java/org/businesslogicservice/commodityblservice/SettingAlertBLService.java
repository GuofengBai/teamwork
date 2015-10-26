package org.businesslogicservice.commodityblservice;

public interface SettingAlertBLService {

	/**
	 * 启动警报设置
	 * @param alartLine 警报线
	 * @return 返回设置是否成功
	 */
	public boolean settingAlert(double alertLine);
}
