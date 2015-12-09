package org.po;

import java.io.Serializable;

public class ResultMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
