package org.Server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.po.BillsPO;
import org.po.CenterPO;
import org.po.CityAndDistancePO;
import org.po.ExpressFeePO;
import org.po.HallPO;
import org.po.TransFeePO;
import org.po.UserPO;

public class Init {
	
	public static void main(String[] args){
		String fileName="SerializableData/"+"OB"+".file";
		try {
			ArrayList<BillsPO> List=new ArrayList<BillsPO>();
			long ueb=0;
			ArrayList<BillsPO> ueList=new ArrayList<BillsPO>();
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(List);
			oos.writeObject(ueb);
			oos.writeObject(ueList);
//			oos.writeObject(new CityAndDistancePO());
//			oos.writeObject(new ExpressFeePO());
//			oos.writeObject(new TransFeePO());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
