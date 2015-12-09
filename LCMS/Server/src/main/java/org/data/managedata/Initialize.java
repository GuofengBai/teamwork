package org.data.managedata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.po.PayingBills;

public class Initialize {
	 public static void main( String[] args ){
		 ArrayList<PayingBills> list=new ArrayList<PayingBills>();
		
		 ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream("SerializableData/PB.file"));
			os.writeObject(list);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	 }
}
