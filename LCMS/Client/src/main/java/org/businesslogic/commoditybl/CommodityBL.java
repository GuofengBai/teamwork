package org.businesslogic.commoditybl;

import org.businesslogicservice.commodityblservice.CommodityBLService;
import org.po.ComPO;

public class CommodityBL implements CommodityBLService{
	public ResultMessage addCom(ComPO po);
	public ResultMessage delCom(ComPO po);
	public ComPO findCom(long GoodsNum);
}
