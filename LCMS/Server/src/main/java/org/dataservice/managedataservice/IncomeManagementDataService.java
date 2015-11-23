package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import org.po.HallCollectionBills;
import org.po.myDate;

public interface IncomeManagementDataService extends Remote{
	public ArrayList<HallCollectionBills> incomeSearch (myDate date,int hallNumber);
}
