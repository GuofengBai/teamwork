package org.businesslogicservice.billsblservice;



import java.util.ArrayList;

import org.omg.PortableServer.POAManagerPackage.State;
import org.po.ResultMessage;
import org.po.StateListPO;
import org.po.myDate;
import org.vo.CABVO;
import org.vo.StateListVO;

public interface NewCenterArriveBillsBLService {
	public ResultMessage addCenterArriveBills(CABVO vo);

}
