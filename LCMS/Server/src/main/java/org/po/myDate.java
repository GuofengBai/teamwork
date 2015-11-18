package org.po;

import java.io.Serializable;

public class myDate implements Serializable{
	
	public int year;
	public int month;
	public int day;
	public myDate(int year, int month, int day) {
		this.year=year;
		this.month=month;
		this.day=day;
	}

}
