package org.dataservice.organizationdataservice;

import java.rmi.Remote;

import org.po.CarPO;
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
	public ResultMessage delHall(int HallNum);
	/**
	 * 添加CenterPO
	 * @return ResultMessage
	 */
	public ResultMessage addCenter(CenterPO po);
	/**
	 * 删除CenterPO
	 * @return ResultMessage
	 */
	public ResultMessage delCenter(int CenterNum);
	/**
	 * 查找HallPO
	 * @param HallNum 营业厅编号
	 * @return HallPO
	 */
	public HallPO findHall(int HallNum);
	/**
	 * 查找CenterPO
	 * @param CenterNum 中转中心编号
	 * @return CenterPO
	 */
	public CenterPO findCenter(int CenterNum);
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

}
