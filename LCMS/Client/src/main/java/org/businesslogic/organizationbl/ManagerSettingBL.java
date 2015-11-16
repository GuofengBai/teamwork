package org.businesslogic.organizationbl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.organizationblservice.ManagerSettingBLService;
import org.dataservice.organizationdataservice.OrganizationDataService;
import org.po.CityAndDistancePO;
import org.po.ResultMessage;
import org.po.StdFeePO;
import org.po.VehFeePO;

public class ManagerSettingBL implements ManagerSettingBLService{
	String[] cities={"北京","广州","上海","南京"};

	public ResultMessage ManagerSetStdFee(double stdfee) {
		OrganizationDataService setStdFee = RMIHelper.getDataFactory().getOrganizationData();
		ResultMessage end=null;
		end=setStdFee.addStdFee(new StdFeePO(stdfee));
		return end;
	}

	public VehFeePO ManagerSetVehFee(int veh, double fee) {
		// TODO Auto-generated method stub
		return null;
	}
	//public void initDistances() throws IOException{
	//	File file = new File("TxtData/Distances.txt");
	//	BufferedWriter bw=new BufferedWriter(new FileWriter("TxtData/Distances.txt"));
	//	for(int i=0;i<cities.length;i++){
	//		bw.write(cities[i]+" ");
	//	}

	public boolean ManagerSetCitiesDistance(String city1, String city2,
			double distance) {
		// TODO Auto-generated method stub
		return false;
	}

	public double getCitiesDistance(String city1, String city2) {
		CityAndDistancePO po = new CityAndDistancePO();
		String[] str={"北京市","上海市","广州市","南京市"};
		double[][] dis={{30,1064.7,1888.8,900},{1064.7,30,1213,266},{1888.8,1213,30,1132},{900,266,1132,30}};
		po.cities=str;
		po.distance=dis;
		int a=0,b=0;
		for(int i=0;i<po.cities.length;i++){
			if(po.cities[i].equals(city1))
				a=i;
			if(po.cities[i].equals(city2))
				b=i;
			System.out.println(a);
			System.out.println(b);
		}
		System.out.println(po.distance[a][b]);
		return po.distance[a][b];		
	}

	public double getStdFee() {
		// TODO Auto-generated method stub
		return 1;
	}

	public double getVehFee(int veh) {
		// TODO Auto-generated method stub
		return 0;
	}
		
	//}

}
