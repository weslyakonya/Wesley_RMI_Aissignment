
package com.start_server;

import com.rmi_interface_impl.VegetableComputeEngine;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class VegetableComputeTaskRegistry {
    
    public static void main(String[] args) throws RemoteException {        
        Registry reg = LocateRegistry.createRegistry(1099);
        VegetableComputeEngine service = new VegetableComputeEngine();
        reg.rebind("SERVER", service);
        System.out.println("server started..........");
        
    }
    
}
