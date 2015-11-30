package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ComPO;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.CommodityVO;
import org.vo.IBVO;

public interface NewInstorageBillsBLService {
	
	public ResultMessage newInstorageBill(IBVO vo);
	
	public void addCommodity(ArrayList<ComPO> list);
}
