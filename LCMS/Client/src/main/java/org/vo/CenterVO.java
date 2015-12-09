package org.vo;

import java.util.Vector;

import org.po.CenterPO;

public class CenterVO extends Vector<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CenterVO(String Name,String Num,String location){
		super();
		this.add(Name);
		this.add(Num);
		this.add(location);
	}
	
	public CenterVO(CenterPO po){
		super();
		this.add(po.getname());
		this.add(po.getCenterNum());
		this.add(po.getLocation());
	}
}
