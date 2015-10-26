package org.businesslogicservice.organizationblservice;

public interface AddCenterBLService {
	/**
	 * 启动新增中转中心
	 * @param cityName城市
	 * @param HallNum 中转中心编号
	 * @param distanceToOtherCities 城市之间距离
	 * @return 返回启动是否成功
	 */
	public boolean AddCenterbl(String cityName, int HallNum,
			double[] distanceToOtherCities);
	/**
	 * 启动设置新城市到其他城市间距离
	 * @param distance 新城市到其他
	 * @return 返回启动是否成功
	 */
	public boolean ManagerSetNewCitiesDistance(double[] distance);
}
