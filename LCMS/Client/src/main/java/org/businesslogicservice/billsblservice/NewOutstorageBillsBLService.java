package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ComPO;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.CommodityVO;
import org.vo.OBVO;

public interface NewOutstorageBillsBLService {
	
	public ResultMessage addOutstorageBills(OBVO vo);
	
	public ResultMessage updateOutstorageBills(OBVO vo);
	
	public void deleteCommodity(ArrayList<ComPO> list);
	
	public CommodityVO creatVO(String goodNum);
	
	public ComPO creatPO(String goodNum);

}
