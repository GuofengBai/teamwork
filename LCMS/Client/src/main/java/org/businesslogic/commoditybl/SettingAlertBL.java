package org.businesslogic.commoditybl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.SettingAlertBLService;
import org.dataservice.commoditydataservice.AlertLineDataService;
import org.po.AlertPO;
import org.po.ResultMessage;

public class SettingAlertBL implements SettingAlertBLService {
	AlertLineDataService ads;

	public boolean settingAlert(String centerNum, double alertLine) {
		// TODO Auto-generated method stub
		AlertPO po = ads.find(centerNum);
		AlertPO newpo = new AlertPO(po.getcenterNum(), po.getnowNumber(),
				alertLine / 100.0);
		if (ads.del(po).success)
			if (ads.add(newpo).success)
				return true;
		return false;
	}

	public double getAlert(String centerNum) {
		double result = ads.find(centerNum).getalertline();
		return result * 100;
	}

	public SettingAlertBL() throws RemoteException {
		ads = RMIHelper.getDataFactory().getAlertData();
	}

	public ResultMessage ALERT(String centerNum) {
		AlertPO po = ads.find(centerNum);
		ResultMessage re;
		String[] alert = { "执行入库将超过警报线！" };
		String[] su = null;
		double nowline = (po.getnowNumber() / po.getfullNumber()) * 1.0;
		double alertline = po.getalertline();
		if (nowline > alertline) {
			return re = new ResultMessage(false, alert);
		} else
			return re = new ResultMessage(true, su);

	}

}
