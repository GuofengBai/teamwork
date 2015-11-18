package org.po;

import java.io.Serializable;


public class InstorageBills extends BillsPO{
	private ComLineItem[] Goods;
	
	public InstorageBills(){
		super();
	}
	
	public InstorageBills(ComLineItem[] Goods){
		super();
		this.Goods=Goods;
	}
}
