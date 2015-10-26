package org.businesslogicservice.organizationblservice;

import org.po.CarPO;

public interface HallChaCarBLService {
	/**
	 * 启动更改车辆信息
	 * @param carNum 车辆编号
	 * @return 返回CarPO，包括汽车编号、发动机号、底盘号、购买时间、服役时间、车牌号
	 */
	public CarPO HallChaCarbl(int carNum);
}
