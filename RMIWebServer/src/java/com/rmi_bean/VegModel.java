
package com.rmi_bean;

import java.io.Serializable;


public class VegModel implements Serializable{
    String vegName;   
    String price;
    String id;

    public String getVegName() {
        return vegName;
    }

    public void setVegName(String vegName) {
        this.vegName = vegName;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
    
}
