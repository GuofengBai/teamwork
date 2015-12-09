package org.vo;

import java.util.Vector;

import org.po.HallPO;

public class HallVO extends Vector<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HallVO(String hallName,String hallNum,String cityName,String location){
		super();
		this.add(hallName);
		this.add(hallNum);
		this.add(cityName);
		this.add(location);
	}
	
	public HallVO(HallPO po){
		super();
		this.add(po.getname());
		this.add(po.getHallNum());
		this.add(po.getcityName());
		this.add(po.getLocation());
	}
}
