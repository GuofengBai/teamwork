package org.data.organizationdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.organizationdataservice.OrganizationDataService;
import org.po.CarPO;
import org.po.CenterPO;
import org.po.CityAndDistancePO;
import org.po.DriverPO;
import org.po.HallPO;
import org.po.ResultMessage;

public class OrganizationData extends UnicastRemoteObject implements OrganizationDataService{

	public OrganizationData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage addHall(HallPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delHall(String HallNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCenter(CenterPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delCenter(String CenterNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public HallPO findHall(String HallNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public CenterPO findCenter(String CenterNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCar(CarPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addDriver(DriverPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delCar(CarPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delDriver(DriverPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public CarPO findCar(int CarNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverPO findDriver(int driverNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public CityAndDistancePO SetCitiesDistance(String city1, String city2,
			double distance) {
		// TODO Auto-generated method stub
		return null;
	}

	public CityAndDistancePO newCityDistance(String city, double[] distance) {
		// TODO Auto-generated method stub
		return null;
	}

}
