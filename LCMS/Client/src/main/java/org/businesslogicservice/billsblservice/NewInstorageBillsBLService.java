package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ComPO;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.CommodityVO;

public interface NewInstorageBillsBLService {
	
	public ResultMessage newInstorageBill(myDate date,String idNum, String centerNum, ArrayList<CommodityVO> list);
	
	public void addCommodity(ArrayList<ComPO> list);
}
