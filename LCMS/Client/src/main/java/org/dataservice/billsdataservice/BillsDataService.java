package org.dataservice.billsdataservice;

import java.rmi.Remote;

import org.po.BillsPO;
import org.po.ResultMessage;

public interface BillsDataService extends Remote{
	public ResultMessage addBills(BillsPO po);
	public ResultMessage findBills(int BillNum);
	public ResultMessage deleteBills(int BillNum);
	public ResultMessage updateBills(int BillNum,BillsPO po);

}
