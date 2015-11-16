package org.businesslogic.organizationbl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

import org.businesslogicservice.organizationblservice.ManagerSettingBLService;
import org.dataservice.organizationdataservice.OrganizationDataService;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.StdFeePO;
import org.po.VehFeePO;

public class ManagerSettingBL implements ManagerSettingBLService{
	String[] cities={"北京","广州","上海","南京"};

	public ResultMessage ManagerSetStdFee(double stdfee) {
		OrganizationDataService setStdFee = RMIHelper.getDataFactory().getOrganizationData();
		ResultMessage end=null;
		try {
			end=setStdFee.addStdFee(new StdFeePO(stdfee));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		// TODO Auto-generated method stub
		return 900;
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
