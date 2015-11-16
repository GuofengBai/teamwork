package org.dataservice.billsdataservice;

import org.po.EXPRESSSTATE;
import org.po.ResultMessage;

public interface NewSendingBillsDataService extends BillsDataService{
	
	public ResultMessage updateExpressState(int BillNum,EXPRESSSTATE expressState);
	
	public EXPRESSSTATE getExpressState(int BillNum);
	
}
