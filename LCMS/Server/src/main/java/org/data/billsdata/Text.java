package org.data.billsdata;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.po.BillsPO;

public class Text {
	public static void main(String[] args) {
		ArrayList<BillsPO> list=new ArrayList<BillsPO>();
		long unExaminedNum=0;
		ArrayList<BillsPO> unExaminedList=new ArrayList<BillsPO>();
		try {
            FileOutputStream fos = new FileOutputStream("SerializableData/CAB.file");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.writeObject((Long)unExaminedNum);
			oos.writeObject(unExaminedList);
            oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}