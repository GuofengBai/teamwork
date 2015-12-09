package org.po;

import java.io.Serializable;

public class myDate implements Serializable,Comparable<myDate>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int year;
	public int month;
	public int day;
	
	public myDate(){
		super();
		year=2015;
		month=11;
		day=10;
	}
	
	public myDate(String s) {
		super();
		this.year=Integer.parseInt(s.substring(0, 4));
		this.month=Integer.parseInt(s.substring(4, 6));
		this.day=Integer.parseInt(s.substring(6, 8));
	}
	
	public myDate(int year, int month, int day) {
		super();
		this.year=year;
		this.month=month;
		this.day=day;
	}

	public int compareTo(myDate date) {

        if(year<date.year){
        	return -1;
        }else if(year>date.year){
        	return 1;
        }else{
        	if(month<date.month){
        		return -1;
        	}else if(month>date.month){
        		return 1;
        	}else{
        		if(day<date.day){
        			return -1;
        		}else if(day>date.day){
        			return 1;
        		}else{
        			return 0;
        		}
        	}
        }
	}
	
	public String toString(){
		String output="";
		
		output=output+String.valueOf(year);
		
		if(month<10){
			output=output+"0"+String.valueOf(month);
		}else{
			output=output+String.valueOf(month);
		}
		if(day<10){
			output=output+"0"+String.valueOf(day);
		}else{
			output=output+String.valueOf(day);
		}
		
		return output;
	}
}
