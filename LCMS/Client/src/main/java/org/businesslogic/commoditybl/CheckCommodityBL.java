package org.businesslogic.commoditybl;

import java.util.ArrayList;
import java.util.Vector;
import java.rmi.RemoteException;
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
		list = cds.getAllCom(centerNum);
		System.out.println(cds.getComSize(centerNum));
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
					centerNum);
			comlist.add(obj);

		}
		return comlist;
	}

}
