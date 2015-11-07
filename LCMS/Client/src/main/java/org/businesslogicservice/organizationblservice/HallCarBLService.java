package org.businesslogicservice.organizationblservice;

import org.po.CarPO;
import org.po.myDate;

public interface HallCarBLService {
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
	public CarPO HallAddCarbl(int carNum, int engineNum, int chassisNum,
			myDate buyTime, myDate serveTime, String number);
	/**
	 * 启动更改车辆信息
	 * @param carNum 车辆编号
	 * @return 返回CarPO，包括汽车编号、发动机号、底盘号、购买时间、服役时间、车牌号
	 */
	public CarPO HallChaCarbl(int carNum);
	/**
	 * 启动删除车辆
	 * @param carNum 车辆编号
	 * @return 返回启动是否成功
	 */
	public boolean HallDelCarbl(int carNum);
}
