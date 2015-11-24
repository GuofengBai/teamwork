package org.vo;

import java.util.Vector;

import org.po.myDate;

public class CommodityVO extends Vector<String> {

	public CommodityVO(String GoodsNum, myDate inDate, String place,
			String LocationNum, String area) {
		this.add(GoodsNum);
		this.add(String.valueOf(inDate.year) + String.valueOf(inDate.month)
				+ String.valueOf(inDate.day));
		this.add(place);
		this.add(LocationNum);
		this.add(area);
	}

	public String getGoodsNum() {
		return this.get(0);
	}

	public String getDate() {
		return this.get(1);
	}

	public String getplace() {
		return this.get(2);

	}

	public String getLocation() {
		return this.get(3);
	}

	public String getarea() {
		return this.get(4);
	}
}
