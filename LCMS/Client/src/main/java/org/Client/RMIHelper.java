package org.Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.dataservice.DataFactoryService.DataFactoryService;
import org.dataservice.billsdataservice.BillsDataService;

public class RMIHelper {
    private static final String IP = "localhost";//Can be read from config file
    private static BillsDataService billsData;

    public static void init() {
        try {
            billsData=  (BillsDataService) Naming.lookup("rmi://" + IP + "/billsData-service");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public static BillsDataService getBillsDataService() {
        return billsData;
    }
}