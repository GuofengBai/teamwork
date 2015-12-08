package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.PayingBills;
import org.po.ResultMessage;
import org.po.myDate;

public interface CostManagementDataService extends Remote{
	/**
	 * 获取所有付款单
	 * 
	 * @return ArrayList<PayingBills>
	 * @throws RemoteException
	 */
	public ArrayList<PayingBills> getAllBill()throws RemoteException;
	
	/**
	 * 修改付款单
	 * 
	 * @param int
	 * @param PayingBills
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage changeBill(int index,PayingBills newBill)throws RemoteException;
	
	/**
	 * 删除付款单
	 * 
	 * @param int
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage delBill(int index)throws RemoteException;
	
	/**
	 * 获取某日期段的付款单
	 * 
	 * @param myDate
	 * @param myDate
	 * @return ArrayList<PayingBills>
	 * @throws RemoteException
	 */
	public ArrayList<PayingBills> getBillByTime(myDate date1, myDate date2)throws RemoteException;
}
