package org.po;

import java.io.Serializable;

public class CityAndDistancePO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String[] cities;
	
	public Double[][] distance;
	
	public CityAndDistancePO(){
		super();
		String[] cs={"北京","上海","南京","广州"};
		this.cities=cs;
		Double[][] ds={{30.0,1064.7,900.0,1888.8},
				{1064.7,30.0,266.0,1213.0},
				{900.0,266.0,30.0,1132.0},
				{1888.8,1213.0,1132.0,30.0}
				};
		this.distance=ds;
		
	}
	
}
