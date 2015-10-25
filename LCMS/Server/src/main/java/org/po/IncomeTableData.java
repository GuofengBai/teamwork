package org.po;

import java.io.Serializable;

public class IncomeTableData implements Serializable{
	int income;
	int payment;
	int earning;
	
	
	public void earningCal(){
		
	}
	
	public int getIncome(){
		return income;
	}
	
	public int getPayment(){
		return payment;
	}
	
	public int getEarning(){
		return earning;
	}
	
}
