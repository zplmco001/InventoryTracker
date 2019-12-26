package edu.aydin.InventoryTracker.Model;

import java.util.HashMap;
import java.util.Map;

public class ShowProduct {

    public String name;
    public String quantity;
    public Map<String,Object> pMap;

    public ShowProduct(HashMap<String,Object> map){

        this.name = map.get("name").toString();
        System.out.println("kkk"+name);
        this.quantity = map.get("quantity").toString();
        System.out.println("kkk"+quantity);
        map.remove("name");
        map.remove("quantity");

        this.pMap = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Map<String, Object> getpMap() {
        return pMap;
    }

    public void setpMap(Map<String, Object> pMap) {
        this.pMap = pMap;
    }

    public Map<String,Object> getAttributes(){
        return this.pMap;
    }

}
