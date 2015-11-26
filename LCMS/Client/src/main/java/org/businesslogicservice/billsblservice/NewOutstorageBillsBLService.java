package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ComPO;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.CommodityVO;

public interface NewOutstorageBillsBLService {
	
	public ResultMessage addOutstorageBills(myDate date, String centerNum, String entruckNum, ArrayList<CommodityVO> list);
	
	public void deleteCommodity(ArrayList<ComPO> list);
	
	public CommodityVO creatVO(String goodNum);
	
	public ComPO creatPO(String goodNum);

}
