package org.dataservice.commoditydataservice;

import java.rmi.Remote;

import org.po.ComPO;
import org.po.ResultMessage;

public interface CommodityDataService extends Remote{
	/**
	 * 娣诲姞ComPO
	 * @return ResultMessage
	 */
	public ResultMessage addCom(ComPO po);
	/**
	 * 鍒犻櫎ComPO
	 * @return ResultMessage
	 */
	public ResultMessage delCom(ComPO po);
	/**
	 * 鏌ユ壘DriverPO
	 * @param GoodsNum 鎵樿繍鍗曞彿
	 * @return ResultMessage
	 */
	public ComPO findCom(long GoodsNum);
}
