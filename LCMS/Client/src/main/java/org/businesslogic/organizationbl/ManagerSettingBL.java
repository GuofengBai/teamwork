package org.businesslogic.organizationbl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.organizationblservice.ManagerSettingBLService;
import org.dataservice.organizationdataservice.ManagerSettingDataService;
import org.dataservice.organizationdataservice.OrganizationDataService;
import org.po.CityAndDistancePO;
import org.po.ResultMessage;
import org.po.ExpressFeePO;
import org.po.SENDSTYPE;
import org.po.TRANSPORTATION;
import org.po.VehFeePO;

public class ManagerSettingBL implements ManagerSettingBLService{

	public boolean setCityDistance(String city1, String city2, double distance) {
		try {
			ManagerSettingDataService manager=RMIHelper.getDataFactory().getOrganizationDataFactory().getManagerSettingData();
		
			CityAndDistancePO cad=manager.getCityAndDistance();
			
			int c1=0,c2=0;
			for(int i=0;i<cad.cities.length;i++){
				if(cad.cities[i].equals(city1)){
					c1=i;
					break;
				}
			}
			for(int i=0;i<cad.cities.length;i++){
				if(cad.cities[i].equals(city1)){
					c2=i;
					break;
				}
			}
			cad.distance[c1][c2]=distance;
			cad.distance[c2][c1]=distance;
			manager.setCityAndDistance(cad);
			return true;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public double getCityDistance(String city1, String city2) {
		try {
			ManagerSettingDataService manager=RMIHelper.getDataFactory().getOrganizationDataFactory().getManagerSettingData();
		
			CityAndDistancePO cad=manager.getCityAndDistance();
			
			int c1=0,c2=0;
			for(int i=0;i<cad.cities.length;i++){
				if(cad.cities[i].equals(city1)){
					c1=i;
					break;
				}
			}
			for(int i=0;i<cad.cities.length;i++){
				if(cad.cities[i].equals(city1)){
					c2=i;
					break;
				}
			}
			
			return cad.distance[c1][c2];
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 30;
	}

	public double getExpressFee(SENDSTYPE type) {
		try {
			ManagerSettingDataService manager=RMIHelper.getDataFactory().getOrganizationDataFactory().getManagerSettingData();
		
			return manager.getExpressFee(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 23;
	}

	public boolean setExpressFee(SENDSTYPE type, double fee) {
		try {
			ManagerSettingDataService manager=RMIHelper.getDataFactory().getOrganizationDataFactory().getManagerSettingData();
		
			manager.setExpressFee(type,fee);
			
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public double getTransFee(TRANSPORTATION type) {
		try {
			ManagerSettingDataService manager=RMIHelper.getDataFactory().getOrganizationDataFactory().getManagerSettingData();
		
			return manager.getTransFee(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public boolean setTransFee(TRANSPORTATION type, double fee) {
		try {
			ManagerSettingDataService manager=RMIHelper.getDataFactory().getOrganizationDataFactory().getManagerSettingData();
		
			manager.setTransFee(type,fee);
			
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean addCity(String cityName) {

		try {
			ManagerSettingDataService manager=RMIHelper.getDataFactory().getOrganizationDataFactory().getManagerSettingData();
		
			CityAndDistancePO cad=manager.getCityAndDistance();
			
			String[] cities=new String[cad.cities.length+1];
			for(int i=0;i<cad.cities.length;i++){
				cities[i]=cad.cities[i];
			}
			cities[cad.cities.length]=cityName;
			cad.cities=cities;
			
			double[][] distance=new double[cad.cities.length][cad.cities.length];
			for(int i=0;i<cad.cities.length;i++){
				for(int j=0;j<cad.cities.length;j++){
					if(i==cad.cities.length-1||j==cad.cities.length-1){
						distance[i][j]=30;
					}else{
						distance[i][j]=cad.distance[i][j];
					}
				}
			}
			cad.distance=distance;
			manager.setCityAndDistance(cad);
			
			
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean delCity(String cityName) {
		try {
			ManagerSettingDataService manager=RMIHelper.getDataFactory().getOrganizationDataFactory().getManagerSettingData();
		
			CityAndDistancePO cad=manager.getCityAndDistance();
			
			String[] cities=new String[cad.cities.length-1];
			int del=0;
			for(int i=0;i<cad.cities.length;i++){
				if(cad.cities[i].equals(cityName)){
					del=i;
					break;
				}
			}
			for(int i=0;i<cad.cities.length-1;i++){
				if(i<del){
					cities[i]=cad.cities[i];
				}else{
					cities[i]=cad.cities[i+1];
				}
			}
			cad.cities=cities;
			
			double[][] distance=new double[cad.cities.length][cad.cities.length];
			for(int i=0;i<cad.cities.length;i++){
				for(int j=0;j<cad.cities.length;j++){
					if(i<del&&j<del){
						distance[i][j]=cad.distance[i][j];
					}else if(i<del&&j>=del){
						distance[i][j]=cad.distance[i][j+1];
					}else if(i>=del&&j<del){
						distance[i][j]=cad.distance[i+1][j];
					}else{
						distance[i][j]=cad.distance[i+1][j+1];
					}
				}
			}
			cad.distance=distance;
			manager.setCityAndDistance(cad);
			
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public CityAndDistancePO getCad() {
		try {
			ManagerSettingDataService manager=RMIHelper.getDataFactory().getOrganizationDataFactory().getManagerSettingData();
		
			CityAndDistancePO cad=manager.getCityAndDistance();
			
			return cad;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
