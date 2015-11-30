package org.dataservice.billsdataservice;

import org.po.EXPRESSSTATE;
import org.po.ResultMessage;

public interface NewSendingBillsDataService extends BillsDataService{
	
	public ResultMessage updateExpressState(String string,EXPRESSSTATE expressState);
	
	public EXPRESSSTATE getExpressState(String BillNum);
	
}
