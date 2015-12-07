package org.businesslogicservice.manageblservice;

public interface IncomeTableBLService {
	/**
	 * 获取总收入
	 * 
	 * @return long
	 */
	public long getIncome();
	
	/**
	 * 获取总支出
	 * 
	 * @return long
	 */
	public long getPayment ();

}
