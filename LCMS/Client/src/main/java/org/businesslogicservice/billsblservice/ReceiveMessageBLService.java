package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.myDate;

public interface ReceiveMessageBLService {
	
	public Boolean addMessage(String goodNum, String receiverName, myDate date);

}
