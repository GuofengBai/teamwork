package org.Server;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.data.DataFactory.DataFactory;
import org.dataservice.DataFactoryService.DataFactoryService;

public class RMIHelper {

    public static void init() {
        try {
            LocateRegistry.createRegistry(1099);

            DataFactoryService dataFactory = new DataFactory();

            Naming.rebind("dataFactory-service", dataFactory);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}

