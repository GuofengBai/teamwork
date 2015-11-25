package org.businesslogic.commoditybl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.SettingAlertBLService;
import org.dataservice.commoditydataservice.AlertLineDataService;

public class SettingAlertBL implements SettingAlertBLService {
	AlertLineDataService ads;

	public boolean settingAlert(double alertLine) {
		// TODO Auto-generated method stub
		return false;
	}

	public double getAlert(String centerNum) {
		int nownumber = ads.find(centerNum).getnowNumber();
		double result = nownumber+0.0 / ads.find(centerNum).getfullNumber();
		return result;
	}

	public SettingAlertBL() throws RemoteException {
		ads = RMIHelper.getDataFactory().getAlertData();
	}

}
