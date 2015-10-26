package org.businesslogicservice.organizationblservice;

import org.po.myDate;

public interface HallAddCarBLService {
	/**
	 * 启动新增车辆
	 * @param carNum汽车编号
	 * @param engineNum引擎编号
	 * @param chassisNum底盘号
	 * @param buyTime购买时间
	 * @param serveTime服役时间
	 * @number 车牌号
	 * @return 返回启动是否成功
	 */
	public boolean HallAddCarbl(int carNum, int engineNum, int chassisNum,
			myDate buyTime, myDate serveTime, String number);
}
