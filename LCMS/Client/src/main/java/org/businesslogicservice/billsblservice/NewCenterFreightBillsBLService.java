package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.myDate;
import org.vo.StateListVO;

public interface NewCenterFreightBillsBLService {
	public ResultMessage addCenterFreightBills(myDate date, String FreightNum,
			String tramNum, String StartPlace, String EndPlace, String caseNum,
			String Scoutername, long price, SENDSTYPE send, ArrayList<StateListVO> vo);
	public long getPrice(SENDSTYPE send, String StartPlace, String EndPlace);

}
