package org.businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.Vector;

import org.po.myDate;
import org.vo.ComVO;
import org.vo.CommodityVO;

public interface CheckCommodityBLService {
	/**
	 * 启动库存盘点
	 * @return 返回启动是否成功
	 * @throws RemoteException 
	 */
	public boolean startCheckCommodity(myDate time,String centerNum) throws RemoteException;
	/**
	 * 库存盘点的显示信息
	 * @return 返回Commodity项信息，包括快递编号、入库日期、目的地、区号、排号、架号、位号
	 */
	public Vector<CommodityVO> checkCommodityInf(String centerNum);
}
