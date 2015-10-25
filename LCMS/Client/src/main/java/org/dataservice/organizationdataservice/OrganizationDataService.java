package org.dataservice.organizationdataservice;

import java.rmi.Remote;

import org.po.CarPO;
import org.po.CenterPO;
import org.po.DriverPO;
import org.po.HallPO;
import org.po.ResultMessage;

public interface OrganizationDataService extends Remote {
	/**
	 * 娣诲姞HallPO
	 * @return ResultMessage
	 */
	public ResultMessage addHall(HallPO po);
	/**
	 * 鍒犻櫎HallPO
	 * @return ResultMessage
	 */
	public ResultMessage delHall(int HallNum);
	/**
	 * 娣诲姞CenterPO
	 * @return ResultMessage
	 */
	public ResultMessage addCenter(CenterPO po);
	/**
	 * 鍒犻櫎CenterPO
	 * @return ResultMessage
	 */
	public ResultMessage delCenter(int CenterNum);
	/**
	 * 鏌ユ壘HallPO
	 * @param HallNum 钀ヤ笟鍘呯紪鍙�
	 * @return HallPO
	 */
	public HallPO findHall(int HallNum);
	/**
	 * 鏌ユ壘CenterPO
	 * @param CenterNum 涓浆涓績缂栧彿
	 * @return CenterPO
	 */
	public CenterPO findCenter(int CenterNum);
	/**
	 * 娣诲姞CarPO
	 * @return ResultMessage
	 */
	public ResultMessage addCar(CarPO po);
	/**
	 * 娣诲姞DriverPO
	 * @return ResultMessage
	 */
	public ResultMessage addDriver(DriverPO po);
	/**
	 * 鍒犻櫎CarPO
	 * @return ResultMessage
	 */
	public ResultMessage delCar(CarPO po);
	/**
	 * 鍒犻櫎DriverPO
	 * @return ResultMessage
	 */
	public ResultMessage delDriver(DriverPO po);
	/**
	 * 鏌ユ壘CarPO
	 * @param CarNum 涓浆涓績缂栧彿
	 * @return CarPO
	 */
	public CarPO findCar(int CarNum);
	/**
	 * 鏌ユ壘DriverPO
	 * @param DriverNum 涓浆涓績缂栧彿
	 * @return DriverPO
	 */
	public DriverPO findDriver(int driverNum);

}