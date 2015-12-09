package org.Server;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.data.DataFactory.DataFactory;
import org.dataservice.DataFactoryService.DataFactoryService;

public class RMIHelper {
	
	public static DataFactoryService data;

    public static void init() {
        try {
            LocateRegistry.createRegistry(1099);
            
            System.out.println("OK");

            data= new DataFactory();
            
            System.out.println("OK");

            Naming.rebind("data-factory",data);
            
            System.out.println("server创建!");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}

