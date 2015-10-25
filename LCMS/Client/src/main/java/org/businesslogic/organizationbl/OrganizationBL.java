package org.businesslogic.organizationbl;

import org.businesslogicservice.organizationblservice.OrganizationBLService;
import org.po.CarPO;
import org.po.DriverPO;
import org.po.myDate;

public class OrganizationBL implements OrganizationBLService{

	public boolean AddCenterbl(String cityName, int HallNum,
			double[] distanceToOtherCities) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean AddHallbl(int city, int CenterNum, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean DelHallbl(int HallNum) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean DelCenterbl(int city) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean HallAddCarbl(int carNum, int engineNum, int chassisNum,
			myDate buyTime, myDate serveTime, String number) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean HallAddDriverbl(int driverNum, String name,
			myDate birthTime, String ID, boolean gender, String phoneNum,
			int licensePeriod) {
		// TODO Auto-generated method stub
		return false;
	}

	public CarPO HallChaCarbl(int carNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverPO HallChaDriverbl(int driverNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean HallDelCarbl(int carNum) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean HallDelDiverbl(int driverNum) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ManagerSetNewCitiesDistance(double[] distance) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ManagerSetCitiesDistance(int city1, int city2,
			double distance) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ManagerSetStdFee(double stdfee) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ManagerSetVehFee(int veh, int fee) {
		// TODO Auto-generated method stub
		return false;
	}

}
