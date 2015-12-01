package org.businesslogic.commoditybl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.SettingAlertBLService;

import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.AlertPO;
import org.po.ResultMessage;

public class SettingAlertBL implements SettingAlertBLService {
	CommodityDataService cds;

	public boolean settingAlert(String centerNum, double alertLine) throws RemoteException {
		// TODO Auto-generated method stub
		AlertPO po = cds.getAlert(centerNum);
		if (cds.setAlert(centerNum, alertLine).success)
			return true;
		else
			return false;

	}

	public double getAlert(String centerNum) throws RemoteException {
		double now=cds.getComSize(centerNum);
		double result=now/10000;
		return result*100.0;
	}

	public SettingAlertBL() throws RemoteException {
		// ads = RMIHelper.getDataFactory().getAlertData();
	}

	public ResultMessage ALERT(String centerNum) throws RemoteException {
		AlertPO po = cds.getAlert(centerNum);
		int nowNum = cds.getAllCom(centerNum).size();
		ResultMessage re;
		String[] alert = { "执行入库将超过警报线！" };
		String[] su = { "入库成功" };
		double nowline = (nowNum * 1.0 / po.getfullNumber() * 1.0) * 1.0;
		double alertline = po.getalertline();
		if (nowline > alertline) {
			return re = new ResultMessage(false, alert);
		} else
			return re = new ResultMessage(true, su);

	}

}
