package org.po;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CityAndDistancePO implements Serializable{
	
	public String[] cities;
	
	public double[][] distance;
	
	/*public CityAndDistancePO(){
		super();
		String fileName="SerializableData/CityAndDistance.file";
		try {
			FileInputStream fis = new FileInputStream(fileName);
	        BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis); 
	        cities= (String[]) ois.readObject();
	        distance=(double[][]) ois.readObject();
	        ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean save(){
		String fileName="SerializableData/CityAndDistance.file";
		try {
            FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cities);
			oos.writeObject(distance);
            oos.close();
            return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}*/

}
