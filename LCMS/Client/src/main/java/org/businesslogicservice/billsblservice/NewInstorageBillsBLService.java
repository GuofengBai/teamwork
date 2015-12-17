package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ComPO;
import org.po.ResultMessage;
import org.vo.IBVO;

public interface NewInstorageBillsBLService {
	
	public ResultMessage newInstorageBill(IBVO vo);
	
	public ResultMessage updateInstorageBill(IBVO vo);
	
	public void addCommodity(ArrayList<ComPO> list);
	
	public String cherk(IBVO vo);
}
