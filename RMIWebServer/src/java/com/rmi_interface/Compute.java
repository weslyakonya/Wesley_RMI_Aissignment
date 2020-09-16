package com.rmi_interface;

import com.rmi_bean.VegModel;
import java.rmi.*;

public interface Compute extends Remote {
    public void add(VegModel vd) throws RemoteException;
    public void update(VegModel vd) throws RemoteException;
    public void delete(VegModel vd) throws RemoteException;
    public String fetch() throws RemoteException;
    public String computeCost() throws RemoteException;
    
}