package org.businesslogic.commoditybl;

import java.rmi.RemoteException;

import org.Client.MockCommodityData;
import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.commodityblservice.CommodityInAndOutBLService;
import org.businesslogicservice.commodityblservice.SettingAlertBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.AlertPO;
import org.po.ComPO;
import org.po.ResultMessage;

public class CommodityInAndOutBL implements CommodityInAndOutBLService {
	/**
	 * 将获得的需要入库货物通过警报线检查后交给数据层完成信息改变
	 */
	public ResultMessage Commodityin(ComPO po) throws RemoteException {
		// TODO Auto-generated method stub
		CommodityDataService cds = RMIHelper.getDataFactory()
				.getCommodityData();
		/**
		 * Mock测试
		 */
		// MockCommodityData mcd=new MockCommodityData();

		SettingAlertBLService sabs = BLFactory.getSettingAlertBL();
		ResultMessage re;
		int size = 0;
		String[] su = { "入库成功" };
		String[] fa = { "入库成功但是货物量已经超过警戒线!" };
		String[] fai = { "入库失败" };
		ResultMessage rem = cds.addCom(po);
		if (rem.success && !sabs.ALERT(po.getcenterNum()).success) {
			return re = new ResultMessage(true, fa);
		} else if (rem.success && sabs.ALERT(po.getcenterNum()).success) {
			return re = new ResultMessage(true, su);
		}
		// if (cds.addCom(po).success&&sabs.ALERT(po.getcenterNum()).success) {
		// return re = new ResultMessage(true, fa);
		else
			return re = new ResultMessage(false, fai);
	}
	/**
	 * 将获得的需要出库货物通过检查后交给数据层完成信息改变
	 */
	public ResultMessage Commodityout(ComPO po) throws RemoteException {
		// TODO Auto-generated method stub
		CommodityDataService cds = RMIHelper.getDataFactory()
				.getCommodityData();
		/**
		 * Mock测试
		 */
		// MockCommodityData mcd=new MockCommodityData();

		SettingAlertBLService sabs = BLFactory.getSettingAlertBL();
		ResultMessage re;
		ResultMessage rem = cds.delCom(po);
		String[] su = { "出库成功" };
		String[] fa = { "出库失败" };

		if (rem.success)
			return re = new ResultMessage(true, su);
		// if (cds.delCom(po).success) {
		// return re = new ResultMessage(true, su);
		else
			return re = new ResultMessage(false, fa);
	}

}
