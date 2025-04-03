package edu.miu.lab3.prob2;

public class Main {
    public static void main(String[] args) {
        Landlord landlord = new Landlord();

        Building blng1 = new Building("Boulever 01", 20);
        blng1.addAppartment(new Appartment("101", 450));
        blng1.addAppartment(new Appartment("102", 450));
        blng1.addAppartment(new Appartment("201", 450));
        blng1.addAppartment(new Appartment("202", 450));
        
        Building blng2 = new Building("Iowa Tower 1", 100);
        blng2.addAppartment(new Appartment("A1", 1500));
        blng2.addAppartment(new Appartment("A2", 1500));
        blng2.addAppartment(new Appartment("B1", 1800));
        blng2.addAppartment(new Appartment("B2", 1800));

        Building blng3 = new Building("The great", 500);
        blng3.addAppartment(new Appartment("A 101", 2500));
        blng3.addAppartment(new Appartment("A 102", 2500));
        blng3.addAppartment(new Appartment("B 201", 3000));
        blng3.addAppartment(new Appartment("B 202", 3000));
        blng3.addAppartment(new Appartment("Pent House", 5000));


        landlord.addBuilding(blng1);
        landlord.addBuilding(blng2);
        landlord.addBuilding(blng3);

        System.out.printf("Landlor Profit : %.2f ",landlord.getLandlordProfit());
    }
}
