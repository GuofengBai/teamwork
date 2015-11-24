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

	public ResultMessage addHall(HallPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delHall(String HallNum) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCenter(CenterPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delCenter(String CenterNum) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public HallPO findHall(String HallNum) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public CenterPO findCenter(String CenterNum) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCar(CarPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addDriver(DriverPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delCar(CarPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delDriver(DriverPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public CarPO findCar(int CarNum) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public DriverPO findDriver(int driverNum) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public CityAndDistancePO SetCitiesDistance(String city1, String city2,
			double distance) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public CityAndDistancePO newCityDistance(String city, double[] distance) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
