package org.businesslogicservice.organizationblservice;

import org.po.CarPO;
import org.po.DriverPO;
import org.po.myDate;

public interface OrganizationBLService {
	
	
	
	/**
	 * 启动删除营业厅
	 * @param city 中转中心编号
	 * @return 返回启动是否成功
	 */
	public boolean DelCenterbl(int city);
	
	
	/**
	 * 启动更改车辆信息
	 * @param carNum 车辆编号
	 * @return 返回CarPO，包括汽车编号、发动机号、底盘号、购买时间、服役时间、车牌号
	 */
	public CarPO HallChaCarbl(int carNum);
	/**
	 * 启动更改司机信息
	 * @param carNum 司机编号
	 * @return 返回DriverPO，包括司机编号、姓名、出生时间、身份证号、性别、电话号码、驾驶证期限
	 */
	public DriverPO HallChaDriverbl(int driverNum);
	/**
	 * 启动删除车辆
	 * @param carNum 车辆编号
	 * @return 返回启动是否成功
	 */
	public boolean HallDelCarbl(int carNum);
	/**
	 * 启动删除司机
	 * @param HallNum 司机编号
	 * @return 返回启动是否成功
	 */
	public boolean HallDelDiverbl(int driverNum);
	/**
	 * 启动设置新城市到其他城市间距离
	 * @param distance 新城市到其他
	 * @return 返回启动是否成功
	 */
	public boolean ManagerSetNewCitiesDistance(double[] distance);
	/**
	 * 启动设置城市间距离
	 * @param city1 城市1（区号）
	 * @param city2 城市2（区号)
	 * @param distance 城市间距离
	 * @return 返回启动是否成功
	 */
	public boolean ManagerSetCitiesDistance(int city1,int city2,double distance);
	/**
	 * 启动设置标准运费
	 * @param stdfee 标准运费
	 * @return 返回启动是否成功
	 */
	public boolean ManagerSetStdFee(double stdfee);
	/**
	 * 启动设置载具运费
	 * @param veh 载具 类型
	 * @param fee 运费
	 * @return 返回启动是否成功
	 */
	public boolean ManagerSetVehFee(int veh, int fee);

}
