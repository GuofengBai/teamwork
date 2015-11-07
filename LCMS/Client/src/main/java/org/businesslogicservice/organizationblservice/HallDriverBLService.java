package org.businesslogicservice.organizationblservice;

import org.po.DriverPO;
import org.po.myDate;

public interface HallDriverBLService {
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
	public DriverPO HallAddDriverbl(int driverNum, String name,
			myDate birthTime, String ID, boolean gender, String phoneNum,
			int licensePeriod);
	/**
	 * 启动更改司机信息
	 * @param carNum 司机编号
	 * @return 返回DriverPO，包括司机编号、姓名、出生时间、身份证号、性别、电话号码、驾驶证期限
	 */
	public DriverPO HallChaDriverbl(int driverNum);
	/**
	 * 启动删除司机
	 * @param HallNum 司机编号
	 * @return 返回启动是否成功
	 */
	public boolean HallDelDriverbl(int driverNum);
}
