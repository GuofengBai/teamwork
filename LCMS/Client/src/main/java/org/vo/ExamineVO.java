package org.vo;

import java.util.Vector;

import org.po.myDate;

public class ExamineVO extends Vector<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExamineVO(String area, myDate in, myDate out, int inNum, int outNum,
			int nowNum) {
		this.add(area);
		this.add(String.valueOf(in.year) + "/" + String.valueOf(in.month) + "/"
				+ String.valueOf(in.day));
		this.add(String.valueOf(out.year) + "/" + String.valueOf(out.month)
				+ "/" + String.valueOf(out.day));
		this.add(String.valueOf(inNum));
		this.add(String.valueOf(outNum));
		this.add(String.valueOf(nowNum));
	}

	public String getArea() {
		return this.get(0);
	}

	public String getInDate() {
		return this.get(1);
	}

	public String getOutDate() {
		return this.get(2);
	}

	public String getInNum() {
		return this.get(3);
	}

	public String getOutNum() {
		return this.get(4);
	}

	public String getNowNum() {
		return this.get(5);
	}
}
