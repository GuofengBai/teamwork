package org.businesslogicservice.commodityblservice;

import java.util.Vector;

import org.po.myDate;
import org.vo.ComVO;
import org.vo.CommodityVO;

public interface CheckCommodityBLService {
	/**
	 * 启动库存盘点
	 * @return 返回启动是否成功
	 */
	public boolean startCheckCommodity(myDate time);
	/**
	 * 库存盘点的显示信息
	 * @return 返回Commodity项信息，包括快递编号、入库日期、目的地、区号、排号、架号、位号
	 */
	public Vector<CommodityVO> checkCommodityInf();
}
