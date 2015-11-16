package org.businesslogicservice.commodityblservice;

import org.po.ComPO;



public interface CommodityInAndOutBLService {
	/**
	 * 入库
	 * @param Sending 快递单号
	 * @return 返回入库是否成功
	 */
	public boolean Commodityin(ComPO po);
	/**
	 * 出库
	 * @param Sending 快递单号
	 * @return 返回出库是否成功
	 */
	public boolean Commodityout(ComPO po);
}
