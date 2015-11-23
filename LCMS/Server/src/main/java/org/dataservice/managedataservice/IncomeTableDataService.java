package org.dataservice.managedataservice;

import java.rmi.Remote;



public interface IncomeTableDataService extends Remote{
	public int getIncome();
	
	public int getPayment ();
}
