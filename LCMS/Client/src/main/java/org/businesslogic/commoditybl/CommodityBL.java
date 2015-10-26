package org.businesslogic.commoditybl;

import org.businesslogicservice.commodityblservice.CommodityBLService;
<<<<<<< HEAD
import org.po.ComPO;

public class CommodityBL implements CommodityBLService{
	public ResultMessage addCom(ComPO po);
	public ResultMessage delCom(ComPO po);
	public ComPO findCom(long GoodsNum);
=======
import org.po.myDate;
import org.vo.ComVO;

public class CommodityBL implements CommodityBLService{

	public boolean startCheckCommodity(myDate time) {
		// TODO Auto-generated method stub
		return false;
	}

	public ComVO checkCommodityInf() {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] examineCommodity(myDate timestart, myDate timeend) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean settingAlert(double alertLine) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean Commodityin(long Sending) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean Commodityout(long Sending) {
		// TODO Auto-generated method stub
		return false;
	}

>>>>>>> origin/master
}
