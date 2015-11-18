package org.po;

import java.io.Serializable;


<<<<<<< HEAD:LCMS/Server/src/main/java/org/po/HallColletcionBills.java
public class HallColletcionBills extends BillsPO{
=======
public class HallCollectionBills extends BillsPO{
	private myDate Date;
>>>>>>> origin/master:LCMS/Server/src/main/java/org/po/HallCollectionBills.java
	private int Cash;
	private String name;
	private String[] GoodsNum;
	
	public HallColletcionBills(myDate t,String s,int c,String name,String[] g){
		this.Date=t;
		this.idNum=s;
		Cash=c;
		this.name=name;
		GoodsNum=g;
	}
	public void setDate(myDate t){
		this.Date=t;
	}
	public myDate getDate(){
		return Date;
	}
	public void setCash(int t){
		this.Cash=t;
	}
	public int getCash(){
		return Cash;
	}
	public void setname(String s){
		this.name=s;
	}
	public String getname(){
		return name;
	}
	public void setGoodsNum(String[] l){
		this.GoodsNum=l;
	}
	public String[] getGoodsNum(){
		return GoodsNum;
	}

}
