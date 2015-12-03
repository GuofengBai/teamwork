package org.data.commoditydata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import org.po.CenterCom;
import org.po.ComPO;
import org.po.myDate;

public class Test  implements java.io.Serializable{
	public LinkedList<CenterCom> totalList;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
		totalList = new LinkedList<CenterCom>();
		myDate date = new myDate(2015, 11, 3);

		ComPO po1 = new ComPO("0000000001", date, "北京市", "0001", "航运区",
				"0250001");// 南京
		ComPO po2 = new ComPO("0000000002", date, "北京市", "0002", "汽运区",
				"0250001");
		ComPO po3 = new ComPO("0000000003", date, "北京市", "0003", "铁运区",
				"0250001");
		ArrayList<ComPO> list1 = new ArrayList<ComPO>();
		list1.add(po1);
		list1.add(po2);
		list1.add(po3);
		CenterCom center1 = new CenterCom(list1, "0250001");

		ComPO po4 = new ComPO("0000000004", date, "南京市", "0001", "空运区",
				"0100001");// 北京
		ComPO po5 = new ComPO("0000000005", date, "南京市", "0002", "汽运区",
				"0100001");
		ComPO po6 = new ComPO("0000000006", date, "南京市", "0003", "铁运区",
				"0100001");
		ArrayList<ComPO> list2 = new ArrayList<ComPO>();
		list2.add(po4);
		list2.add(po5);
		list2.add(po6);
		CenterCom center2 = new CenterCom(list1, "0100001");

		ComPO po7 = new ComPO("0000000007", date, "广州市", "0001", "空运区",
				"0210001");// 上海
		ComPO po8 = new ComPO("0000000008", date, "广州市", "0002", "汽运区",
				"0210001");
		ComPO po9 = new ComPO("0000000009", date, "广州市", "0003", "铁运区",
				"0210001");
		ArrayList<ComPO> list3 = new ArrayList<ComPO>();
		list3.add(po7);
		list3.add(po8);
		list3.add(po9);
		CenterCom center3 = new CenterCom(list3, "0210001");

		ComPO po10 = new ComPO("0000000010", date, "上海市", "0001", "空运区",
				"0200001");// 广州
		ComPO po11 = new ComPO("0000000011", date, "上海市", "0002", "汽运区",
				"0200001");
		ComPO po12 = new ComPO("0000000012", date, "上海市", "0003", "铁运区",
				"0200001");
		ArrayList<ComPO> list4 = new ArrayList<ComPO>();
		list4.add(po10);
		list4.add(po11);
		list4.add(po12);
		CenterCom center4 = new CenterCom(list4, "0200001");

		totalList.add(center1);
		totalList.add(center2);
		totalList.add(center3);
		totalList.add(center4);
	}

	public void writer() {
		try {

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

	public static void main(String[] args) {
		
		Test t1=new Test();
		t1.init();
		t1.writer();
	}
}