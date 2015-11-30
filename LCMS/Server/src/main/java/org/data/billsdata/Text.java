package org.data.billsdata;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import org.po.BillsPO;
import org.po.CenterArriveBills;

public class Text {
	public static void main(String[] args) {
		ArrayList<BillsPO> list=null;
		long unExaminedNum=0;
		ArrayList<BillsPO> unExaminedList=null;
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