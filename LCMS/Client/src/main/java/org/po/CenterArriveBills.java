package org.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.vo.StateListVO;


public class CenterArriveBills extends BillsPO{
	private String CenterNum;
	private myDate date;
	private String FreightNum;
	private ArrayList<StateListVO> vo;
	public CenterArriveBills(myDate date, String FreightNum,
			String CenterNum, ArrayList<StateListVO> vo){
		this.CenterNum=CenterNum;
		this.date=date;
		this.FreightNum=FreightNum;
		this.vo=vo;
		
	}
}
