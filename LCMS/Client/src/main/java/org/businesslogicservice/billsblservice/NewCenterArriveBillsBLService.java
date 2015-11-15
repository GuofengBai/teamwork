package org.businesslogicservice.billsblservice;



import org.omg.PortableServer.POAManagerPackage.State;
import org.po.ResultMessage;
import org.po.myDate;

public interface NewCenterArriveBillsBLService {
	public ResultMessage addCenterArriveBills(myDate date, String FreightNum, String CenterNum);

}
