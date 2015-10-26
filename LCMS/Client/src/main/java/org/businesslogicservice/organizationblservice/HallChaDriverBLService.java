package org.businesslogicservice.organizationblservice;

import org.po.DriverPO;

public interface HallChaDriverBLService {
	/**
	 * 启动更改司机信息
	 * @param carNum 司机编号
	 * @return 返回DriverPO，包括司机编号、姓名、出生时间、身份证号、性别、电话号码、驾驶证期限
	 */
	public DriverPO HallChaDriverbl(int driverNum);
}
