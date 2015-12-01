package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.myDate;
import org.vo.CFBVO;
import org.vo.StateListVO;

public interface NewCenterFreightBillsBLService {
	public ResultMessage addCenterFreightBills(CFBVO vo);
	public long getPrice(SENDSTYPE send, String StartPlace, String EndPlace);
	public ResultMessage updateCenterFreightBills(CFBVO vo);

}
