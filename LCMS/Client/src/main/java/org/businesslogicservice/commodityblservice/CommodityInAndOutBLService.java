package org.businesslogicservice.commodityblservice;

public interface CommodityInAndOutBLService {
	/**
	 * 入库
	 * @param Sending 快递单号
	 * @return 返回入库是否成功
	 */
	public boolean Commodityin(long Sending);
	/**
	 * 出库
	 * @param Sending 快递单号
	 * @return 返回出库是否成功
	 */
	public boolean Commodityout(long Sending);
}
