package org.businesslogicservice.organizationblservice;

import org.po.myDate;

public interface HallAddDriverBLService {
	/**
	 * 启动新增司机
	 * @param driverNum司机编号
	 * @param name姓名
	 * @param birthTime 出生时间
	 * @param ID 身份证号
	 * @param gender 性别
	 * @aram  phoneNum 电话号码
	 * @param licensePeriod 驾驶证期限
	 * @return 返回启动是否成功
	 */
	public boolean HallAddDriverbl(int driverNum, String name,
			myDate birthTime, String ID, boolean gender, String phoneNum,
			int licensePeriod);
}
