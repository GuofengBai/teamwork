package org.businesslogicservice.billsblservice;



import java.util.ArrayList;

import org.omg.PortableServer.POAManagerPackage.State;
import org.po.ResultMessage;
import org.po.myDate;
import org.vo.StateListVO;

public interface NewCenterArriveBillsBLService {
	public ResultMessage addCenterArriveBills(myDate date, String FreightNum, String CenterNum, String[] vo);

}
