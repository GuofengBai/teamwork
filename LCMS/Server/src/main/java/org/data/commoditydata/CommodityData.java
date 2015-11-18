package org.data.commoditydata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.BillsPO;
import org.po.ComPO;
import org.po.ResultMessage;

public class CommodityData extends UnicastRemoteObject implements
		CommodityDataService {

	public ArrayList<ComPO> ComList;

	protected CommodityData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage addCom(ComPO po) {
		// TODO Auto-generated method stub
		String fileName = "SerializableData/Com.file";
		System.out.println(fileName);
		try {
			ComList.add(po);
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ComList);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultMessage re = new ResultMessage(true, null);
		return re;
	}

	public ResultMessage delCom(ComPO po) {
		// TODO Auto-generated method stub
		String fileName = "SerializableData/Com.file";
		System.out.println(fileName);
		FileInputStream fis;
		ObjectInputStream ois = null;
		int i = 0;
		try {
			fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			ComList = (ArrayList<ComPO>) ois.readObject();
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
		ResultMessage re;
		String[] info = { "Success!", "delete." };
		FileOutputStream fos;
		for (ComPO ppo : ComList) {
			if (ppo.getGoodsNum() == po.getGoodsNum()) {
				ComList.remove(ppo);
				try {
					fos = new FileOutputStream(fileName);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(ComList);
					ois.close();
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return re = new ResultMessage(true, info);
			} else {
				try {
					fos = new FileOutputStream(fileName);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(ComList);
					ois.close();
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
		String[] infof = { "failed", "no find" };
		return re = new ResultMessage(false, infof);

	}

	@SuppressWarnings("unchecked")
	public ComPO findCom(String GoodsNum) {
		// TODO Auto-generated method stub
		String fileName = "SerializableData/Com.file";
		System.out.println(fileName);
		FileInputStream fis;
		ObjectInputStream ois = null;
		int i = 0;
		try {
			fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			ComList = (ArrayList<ComPO>) ois.readObject();
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
		FileOutputStream fos;
		for (ComPO po : ComList) {
			if (po.getGoodsNum() == GoodsNum) {
				try {
					fos = new FileOutputStream(fileName);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(ComList);
					ois.close();
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return po;

			}
		}

		return null;
	}
	//public ArrayList<ComPO> (myDate start,myDate end){
	//	
	//}
}
