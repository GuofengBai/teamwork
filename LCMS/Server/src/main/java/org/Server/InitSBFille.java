package org.Server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.po.BillsPO;

public class InitSBFille {
	
	public static void main(String[] args){
		String fileName="SerializableData/"+"SB"+".file";
		try {
			ArrayList<BillsPO> billsList=new ArrayList<BillsPO>();
			billsList.add(new BillsPO());
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(billsList);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
