package org.po;

import java.io.Serializable;
import java.util.ArrayList;

public class CommodityPO implements Serializable{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ComPO> muster=new ArrayList<ComPO>();
	private ResultMessage rm=null;
	
	public ArrayList<ComPO> getmuster (){
		return muster;
	};
	public ResultMessage addCom(ComPO e){
		this.muster.add(e);
		String[] result=null;
		rm=new ResultMessage(true,result);
		return rm;
	}
	public ResultMessage delCom(String GoodsNum){
		String[] result=null;
		for(ComPO po:muster){
			if(po.getGoodsNum().equals(GoodsNum)){
				muster.remove(po);
				rm=new ResultMessage(true,result);
				return rm;
			}
		}
		return rm=new ResultMessage(false,result);
	}
	public ComPO findCom(String GoodsNum){
		for(ComPO po:muster){
			if(po.getGoodsNum().equals(GoodsNum)){
				return po;
			}
		}
		return null;
	}
}
