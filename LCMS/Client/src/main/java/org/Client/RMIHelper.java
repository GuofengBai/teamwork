package org.Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.dataservice.DataFactoryService.DataFactoryService;

public class RMIHelper {
    private static final String IP = "localhost";//Can be read from config file
    private static DataFactoryService dataFactory;

    public static void init() {
        try {
            dataFactory=  (DataFactoryService) Naming.lookup("rmi://" + IP + "/DataFactory-service");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public static DataFactoryService getOrderService() {
        return dataFactory;
    }
}