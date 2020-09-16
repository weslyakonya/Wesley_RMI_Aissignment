package com.rmi_interface_impl;

import com.rmi_bean.VegModel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import com.rmi_interface.Compute;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class VegetableComputeEngine extends UnicastRemoteObject implements Compute {

    Connection conn;

    public VegetableComputeEngine() throws RemoteException {
        getConnection();
    }

    public void getConnection() throws RemoteException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/rmiDB", "rmi", "rmi");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
        }

    }

    @Override
    public void add(VegModel vg) throws RemoteException {
        try {

            String q = "INSERT INTO veges(veg_name,price) values(?,?)";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.setString(1, vg.getVegName());
            pst.setString(2, vg.getPrice());
            pst.executeUpdate();
        } catch (SQLException e) {
        }

    }

    @Override
    public void update(VegModel vg) throws RemoteException {

        try {
            String q = "Update veges set veg_name =?,price=? where id = ? ";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.setString(1, vg.getVegName());
            pst.setString(2, vg.getPrice());
            pst.setInt(3, Integer.parseInt(vg.getId()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VegetableComputeEngine.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(VegModel vg) throws RemoteException {
        try {
            String q = "delete from veges where id = ? ";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.setInt(1, Integer.parseInt(vg.getId()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VegetableComputeEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String fetch() throws RemoteException {
        
      
        String p = "";
        try {
            String q = "select id,veg_name,price from veges";
            PreparedStatement pst = conn.prepareStatement(q);           
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                p +=rs.getString("veg_name")+"BR"+rs.getString("price")+"BR"+rs.getString("id")+"EN";

            }


            
        } catch (SQLException ex) {
            System.out.println("errrorrr====="+ex.getMessage());
            Logger.getLogger(VegetableComputeEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public String computeCost() throws RemoteException {
        
        String p = "";
        try {
            String q = "select sum(price) as cost from veges";
            PreparedStatement pst = conn.prepareStatement(q);           
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                p = rs.getString("cost");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VegetableComputeEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

}
