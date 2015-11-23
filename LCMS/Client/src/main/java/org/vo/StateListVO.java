package org.vo;

import java.util.Vector;

public class StateListVO extends Vector<String>{
	private static final long serialVersionUID = 1L;
	public StateListVO(String GoodsNum,String goodState){
		this.add(GoodsNum);
		this.add(goodState);
	}

}
