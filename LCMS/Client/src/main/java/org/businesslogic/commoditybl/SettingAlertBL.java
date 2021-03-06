package org.businesslogic.commoditybl;

import java.rmi.RemoteException;
import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.SettingAlertBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.AlertPO;
import org.po.ResultMessage;

public class SettingAlertBL implements SettingAlertBLService {
	CommodityDataService cds = RMIHelper.getDataFactory().getCommodityData();

	// MockCommodityData mcd=new MockCommodityData();
	/**
	 * 设置当前中转中心的警报线
	 */
	public boolean settingAlert(String centerNum, double alertLine)
			throws RemoteException {
		// TODO Auto-generated method stub
		// AlertPO po = cds.getAlert(centerNum);
		/**
		 * Mock测试
		 */

		// AlertPO po = mcd.getAlert(centerNum);
		if (cds.setAlert(centerNum, alertLine).success)
			return true;
		else
			return false;
		// if (cds.setAlert(centerNum, alertLine).success)
		// return true;
		// else
		// return false;

	}
	/**
	 * 获得当前的货物线
	 */

	public double getAlert(String centerNum) throws RemoteException {
		// double now=cds.getComSize(centerNum);
		// double result=now/10000;
		/**
		 * Mock测试
		 */
		int now = cds.getComSize(centerNum);
		// int temp=3000;
		double result = (now / 10000.0);
		return result * 100.0;
	}

	public SettingAlertBL() throws RemoteException {
		// ads = RMIHelper.getDataFactory().getAlertData();
		/**
		 * Mock测试
		 */
	}
	/**
	 * 入库警报，需要注意的是，如果完成当前入库后超过警报线，那么入库会被完成同时提示警报
	 * 
	 */

	public ResultMessage ALERT(String centerNum) throws RemoteException {
		// AlertPO po = cds.getAlert(centerNum);
		// int nowNum = cds.getAllCom(centerNum).size();
		/**
		 * Mock测试
		 */
		AlertPO po = cds.getAlert(centerNum);
		int nowNum = cds.getComSize(centerNum);
		String[] alert = { "执行入库将超过警报线！" };
		String[] su = { "入库成功" };
		double nowline = (nowNum * 1.0 / po.getfullNumber() * 1.0) * 1.0;
		double alertline = po.getalertline();
		if (nowline > alertline) {
			return  new ResultMessage(false, alert);
		} else
			return  new ResultMessage(true, su);

	}

}
