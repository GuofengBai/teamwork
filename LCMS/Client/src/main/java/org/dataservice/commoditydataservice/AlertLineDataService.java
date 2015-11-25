package org.dataservice.commoditydataservice;

import org.po.AlertPO;
import org.po.ResultMessage;

public interface AlertLineDataService {
	public ResultMessage add(AlertPO po);
	public AlertPO find(String centerNum);
	public ResultMessage del(AlertPO po);
	public void init();
}
