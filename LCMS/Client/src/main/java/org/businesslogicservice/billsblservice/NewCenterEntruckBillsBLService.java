package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.vo.CEBVO;


public interface NewCenterEntruckBillsBLService {
	public ResultMessage addCenterEntruckBills(CEBVO vo);
	public ResultMessage updateCenterEntruckBills(CEBVO vo);
	public String cherk(CEBVO vo);
	public String search(String GoodNum);

}
