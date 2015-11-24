package org.vo;

import java.util.Vector;

import org.po.myDate;

public class CommodityVO extends Vector<String>{
	

	public CommodityVO(String GoodsNum, myDate inDate, String place, String LocationNum,String area) {
		this.add(GoodsNum);
		this.add(String.valueOf(inDate.year)+String.valueOf(inDate.month)+String.valueOf(inDate.day));
		this.add(place);
		this.add(LocationNum);
		this.add(area);
	}
}
