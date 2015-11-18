package org.po;

import java.io.Serializable;


public class OutstorageBills extends BillsPO{
	
    private ComLineItem[] Goods;
	
	public OutstorageBills(){
		super();
	}
	
	public OutstorageBills(ComLineItem[] Goods){
		super();
		this.Goods=Goods;
	}

}
