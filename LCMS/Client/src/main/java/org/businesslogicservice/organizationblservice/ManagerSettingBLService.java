package org.businesslogicservice.organizationblservice;

public interface ManagerSettingBLService {
	/**
	 * 启动设置城市间距离
	 * @param city1 城市1（区号）
	 * @param city2 城市2（区号)
	 * @param distance 城市间距离
	 * @return 返回启动是否成功
	 */
	public boolean ManagerSetCitiesDistance(String city1,String city2,double distance);
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
	public boolean ManagerSetVehFee(int veh, double fee);
	
	public double getCitiesDistance(String city1,String city2);
	
	public double getStdFee();
	
	public double getVehFee(int veh);
}
