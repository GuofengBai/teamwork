package org.Server;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.data.DataFactory.DataFactory;
import org.dataservice.DataFactoryService.DataFactoryService;
import org.dataservice.Impl.BillsDataServiceSerializableFileImpl;
import org.dataservice.billsdataservice.BillsDataService;

public class RMIHelper {

    public static void init() {
        try {
            LocateRegistry.createRegistry(1099);

            DataFactoryService data= new DataFactory();

            Naming.rebind("data-factory",data);
            
            System.out.println("server创建!");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}

