package org.po;

import java.io.Serializable;

public class myDate implements Serializable,Comparable<myDate>{
	
	public int year;
	public int month;
	public int day;
	
	public myDate(){
		super();
		year=2015;
		month=11;
		day=10;
	}
	
	public myDate(int year, int month, int day) {
		super();
		this.year=year;
		this.month=month;
		this.day=day;
	}

	public int compareTo(myDate date) {

        if(year<date.year){
        	return 1;
        }else if(year>date.year){
        	return -1;
        }else{
        	if(month<date.month){
        		return 1;
        	}else if(month>date.month){
        		return -1;
        	}else{
        		if(day<date.day){
        			return 1;
        		}else if(day>date.day){
        			return -1;
        		}else{
        			return 0;
        		}
        	}
        }
	}

}
