package org.Client;

import org.businesslogic.organizationbl.ManagerSettingBL;
import org.businesslogicservice.organizationblservice.ManagerSettingBLService;



public class MockManagerSettingBL implements ManagerSettingBLService{
	double distance=0;
	double standerdFee=0;
	public MockManagerSettingBL(double a,double b){
		distance=a;
		standerdFee=b;
	}
	public boolean ManagerSetCitiesDistance(String city1, String city2,
			double distance) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean ManagerSetStdFee(double stdfee) {
		// TODO Auto-generated method stub
		return false;
	}
	public double getCitiesDistance(String city1, String city2) {
		// TODO Auto-generated method stub
		return distance;
	}
	public double getStdFee() {
		// TODO Auto-generated method stub
		return standerdFee;
	}
	public double getVehFee(int veh) {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean ManagerSetVehFee(int veh, double fee) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
