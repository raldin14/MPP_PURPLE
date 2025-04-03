package edu.miu.lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    List<Building> buildings;

    public Landlord(){
        buildings = new ArrayList<>();
    }

    public void addBuilding(Building build){
        buildings.add(build);
    }

    public double getLandlordProfit(){
        double totalProfit = 0;
        for(Building bldg:buildings){
            totalProfit += bldg.totalProfit();
        }

        return totalProfit;
    }
    
}
