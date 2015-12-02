package org.data.commoditydata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import org.po.CenterCom;

public class Test {

	public static void main(String[] args) {
		try {
			LinkedList<CenterCom> totalList=new LinkedList<CenterCom>();
			FileOutputStream fos = new FileOutputStream(
					"SerializableData/Com.file");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(totalList);

			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}