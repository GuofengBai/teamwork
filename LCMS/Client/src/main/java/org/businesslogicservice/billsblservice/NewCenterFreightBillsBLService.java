package org.businesslogicservice.billsblservice;


import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.vo.CFBVO;

public interface NewCenterFreightBillsBLService {
	public ResultMessage addCenterFreightBills(CFBVO vo);
	public long getPrice(SENDSTYPE send, String StartPlace, String EndPlace);
	public ResultMessage updateCenterFreightBills(CFBVO vo);
	public String cherk(CFBVO vo);

}
