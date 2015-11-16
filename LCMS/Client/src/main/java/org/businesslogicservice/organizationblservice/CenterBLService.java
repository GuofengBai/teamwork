package org.businesslogicservice.organizationblservice;

import org.po.CenterPO;

public interface CenterBLService {
	/**
	 * 启动新增中转中心
	 * @param cityName城市
	 * @param CityNum 中转中心编号
	 * @param distanceToOtherCities 城市之间距离
	 * @return 返回启动是否成功
	 */
	public CenterPO AddCenterbl(String cityName, String CityNum,
			double[] distanceToOtherCities);
	/**
	 * 启动设置新城市到其他城市间距离
	 * @param distance 新城市到其他
	 * @return 返回启动是否成功
	 */
	public boolean ManagerSetNewCitiesDistance(String city,double[] distance);
	/**
	 * 启动删除中转中心
	 * @param city 中转中心编号
	 * @return 返回启动是否成功
	 */
	public boolean DelCenterbl(String city);
}


