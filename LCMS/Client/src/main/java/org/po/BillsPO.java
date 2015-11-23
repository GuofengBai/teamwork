package org.po;

import java.io.Serializable;


public class BillsPO implements Serializable,Comparable<BillsPO>{
	public boolean Examined;
	public BILLSTYPE type;
	public myDate Date;
	public String idNum;
	
	
	
	public int compareTo(BillsPO o) {
		if(Date.compareTo(o.Date)<0){
			return -1;
		}else if(Date.compareTo(o.Date)>0){
			return 1;
		}
		return 0;
	}
}
