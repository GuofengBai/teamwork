package org.po;

import java.io.Serializable;

public class ResultMessage implements Serializable{
	
	public boolean success;
	public String[] info;
	
	public ResultMessage(){
		super();
	}
	
	public ResultMessage(boolean sc,String[] info){
		super();
		this.success=sc;
		this.info=info;
	}

}
