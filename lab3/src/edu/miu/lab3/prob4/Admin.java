package edu.miu.lab3.prob4;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    List<Property> properties = new ArrayList<>();

    public void addProperty(Property property){
        properties.add(property);
    }

    public double computeTotalrent(){
        double totalRent = 0;
        for(Property prop:properties){
            totalRent += prop.getRent();
        }
        return totalRent;
    }

    public void listAllPropertiesByCity(String city){
        for(Property prop:properties){
            if(prop.getAddress().contains(city)){
                System.out.println(prop.getAddress());
            }
        }
    }

    public void listAllProperties(){
        for(Property prop:properties){
            System.out.println(prop.getAddress());
        }
    }
}
