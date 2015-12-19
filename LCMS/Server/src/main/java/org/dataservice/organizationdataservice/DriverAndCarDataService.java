package org.dataservice.organizationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.CarPO;
import org.po.CityAndDistancePO;
import org.po.DriverPO;
import org.po.ResultMessage;

public interface DriverAndCarDataService extends Remote {
	
	public ResultMessage addCar(CarPO po)throws RemoteException;
	/**
	 * 添加DriverPO
	 * @return ResultMessage
	 */
	public ResultMessage addDriver(DriverPO po)throws RemoteException;
	/**
	 * 删除CarPO
	 * @return ResultMessage
	 */
	public ResultMessage delCar(String CarNum)throws RemoteException;
	/**
	 * 删除DriverPO
	 * @return ResultMessage
	 */
	public ResultMessage delDriver(String driverNum)throws RemoteException;
	/**
	 * 查找CarPO
	 * @param CarNum 车辆编号
	 * @return CarPO
	 */
	public CarPO findCar(String CarNum)throws RemoteException;
	/**
	 * 查找DriverPO
	 * @param DriverNum 司机编号
	 * @return DriverPO
	 */
	public DriverPO findDriver(String driverNum)throws RemoteException;
	/**
	 * 
	 * @param HallNum 营业厅编号
	 * @return ArrayList<CarPO>
	 * @throws RemoteException
	 */
	public ArrayList<CarPO> findCarByHall(String HallNum)throws RemoteException;
	/**
	 * 
	 * @param HallNum 营业厅编号
	 * @return ArrayList<CarPO>
	 * @throws RemoteException
	 */
	public ArrayList<DriverPO> findDriverByHall(String HallNum)throws RemoteException; 
}
