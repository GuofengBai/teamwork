package org.po;

import java.io.Serializable;

public class WorkSpace implements Serializable{
	
	public String type;               //类型，分为“总部”、“中转中心”、“营业厅”
	public String num;
	
	public String toString(){
		if(type.equals("总部")){
			return type;
		}else{
			return type+num;
		}
	}
	
}
