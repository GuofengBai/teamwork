package org.businesslogic.organizationbl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.businesslogicservice.organizationblservice.ManagerSettingBLService;

public class ManagerSettingBL implements ManagerSettingBLService{
	String[] cities={"北京","广州","上海","南京"};
	public boolean ManagerSetCitiesDistance(int city1, int city2,
			double distance) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ManagerSetStdFee(double stdfee) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ManagerSetVehFee(int veh, int fee) {
		// TODO Auto-generated method stub
		return false;
	}
	//public void initDistances() throws IOException{
	//	File file = new File("TxtData/Distances.txt");
	//	BufferedWriter bw=new BufferedWriter(new FileWriter("TxtData/Distances.txt"));
	//	for(int i=0;i<cities.length;i++){
	//		bw.write(cities[i]+" ");
	//	}
		
	//}

}
