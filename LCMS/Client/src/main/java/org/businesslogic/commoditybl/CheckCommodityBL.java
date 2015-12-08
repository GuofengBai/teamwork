package org.businesslogic.commoditybl;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import org.Client.MockCommodityData;
import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.CheckCommodityBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.myDate;

import org.vo.CommodityVO;

public class CheckCommodityBL implements CheckCommodityBLService {
	Vector<CommodityVO> comlist;
	ArrayList<ComPO> list;

	/**
	 * 开始库存盘点 得到截止当前日期的货物信息列表
	 */
	public boolean startCheckCommodity(myDate time, String centerNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		CommodityDataService cds = RMIHelper.getDataFactory()
				.getCommodityData();
		/**
		 * Mock测试
		 */
		//MockCommodityData mcd = new MockCommodityData();

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String curdate = simpleDateFormat.format(date);
		int year = Integer.parseInt(curdate.substring(0, 4));
		int month = Integer.parseInt(curdate.substring(4, 6));
		int day = Integer.parseInt(curdate.substring(6, 8));
		myDate today = new myDate(year, month, day);

		/**
		 * Mock测试
		 */
		// list = cds.getAllCom(centerNum);
		list = cds.getAllCom(centerNum);
		return false;
	}

	/**
	 * 将货物信息转换为table中可显示的格式返回到显示层
	 */
	public Vector<CommodityVO> checkCommodityInf(String centerNum) {
		// TODO Auto-generated method stub
		comlist = new Vector<CommodityVO>();
		for (ComPO po : list) {

			CommodityVO obj = new CommodityVO(po.getGoodsNum(), po.getinDate(),
					po.getplace(), po.LocationNum(), po.getArea(),
					po.getcenterNum());
			comlist.add(obj);

		}
		return comlist;
	}

}
