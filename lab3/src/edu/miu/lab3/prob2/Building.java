package edu.miu.lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private double maintenance;
    private String building;
    private List<Appartment> appts;

    public Building(String building, double maintenance){
        this.building = building;
        this.maintenance = maintenance;
        appts = new ArrayList<>();
    }

    public void addAppartment(Appartment apto){
        appts.add(apto);
    }

    public String getBuilding(){
        return building;
    }
    
    public double getTotalRent(){
        double totalRent = 0;
        for(Appartment apt:appts){
            totalRent += apt.getRent();
        }

        return totalRent;
    }

    public double totalProfit(){
        return getTotalRent() - maintenance;
    }
}
