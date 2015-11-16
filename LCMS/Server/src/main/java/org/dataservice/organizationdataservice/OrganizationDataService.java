package org.dataservice.organizationdataservice;

import java.rmi.Remote;

import org.po.CarPO;
import org.po.CityAndDistancePO;
import org.po.HallPO;
import org.po.CenterPO;
import org.po.DriverPO;
import org.po.ResultMessage;

public interface OrganizationDataService extends Remote {
	/**
	 * 添加HallPO
	 * @return ResultMessage
	 */
	public ResultMessage addHall(HallPO po);
	/**
	 * 删除HallPO
	 * @return ResultMessage
	 */
	public ResultMessage delHall(String HallNum);
	/**
	 * 添加CenterPO
	 * @return ResultMessage
	 */
	public ResultMessage addCenter(CenterPO po);
	/**
	 * 删除CenterPO
	 * @return ResultMessage
	 */
	public ResultMessage delCenter(String CenterNum);
	/**
	 * 查找HallPO
	 * @param HallNum 营业厅编号
	 * @return HallPO
	 */
	public HallPO findHall(String HallNum);
	/**
	 * 查找CenterPO
	 * @param CenterNum 中转中心编号
	 * @return CenterPO
	 */
	public CenterPO findCenter(String CenterNum);
	/**
	 * 添加CarPO
	 * @return ResultMessage
	 */
	public ResultMessage addCar(CarPO po);
	/**
	 * 添加DriverPO
	 * @return ResultMessage
	 */
	public ResultMessage addDriver(DriverPO po);
	/**
	 * 删除CarPO
	 * @return ResultMessage
	 */
	public ResultMessage delCar(CarPO po);
	/**
	 * 删除DriverPO
	 * @return ResultMessage
	 */
	public ResultMessage delDriver(DriverPO po);
	/**
	 * 查找CarPO
	 * @param CarNum 中转中心编号
	 * @return CarPO
	 */
	public CarPO findCar(int CarNum);
	/**
	 * 查找DriverPO
	 * @param DriverNum 中转中心编号
	 * @return DriverPO
	 */
	public DriverPO findDriver(int driverNum);
	/**
	 * 改变两个城市之间的距离
	 * @param city1 城市1的区号
	 * @param city2 城市2的区号
	 * @param distance 距离
	 * @return CityAndDistancePO
	 */
	public CityAndDistancePO SetCitiesDistance(String city1,String city2,double distance);
	/**
	 * 设置新城市到其他城市的距离
	 * @param DriverNum 中转中心编号
	 * @return DriverPO
	 */
	public CityAndDistancePO newCityDistance(String city,double[] distance);

}
