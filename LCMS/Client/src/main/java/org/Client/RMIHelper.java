package org.Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.dataservice.DataFactoryService.DataFactoryService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.commoditydataservice.CommodityDataService;

public class RMIHelper {
    private static final String IP = "localhost";//Can be read from config file
    private static DataFactoryService dataFactory;

    public static void init() {
        try {
            dataFactory=(DataFactoryService)Naming.lookup("rmi://" + IP + "/data-factory");

            System.out.println("client创建!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public static DataFactoryService getDataFactory() {
        return billsData;
    }

	public static CommodityDataService getCommodityDataService() {
		// TODO Auto-generated method stub
		return null;
	}
}