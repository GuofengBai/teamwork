package org.businesslogicservice.billsblservice;



import org.po.ResultMessage;
import org.vo.CABVO;


public interface NewCenterArriveBillsBLService {
	public ResultMessage addCenterArriveBills(CABVO vo);
	
	public ResultMessage updateCenterArriveBills(CABVO vo);
	
	public String cherk(CABVO vo);

}
