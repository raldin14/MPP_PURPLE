package edu.miu.lab3.prob4;

public class Driver {
    public static void main(String[] args) {
        Admin admin = new Admin();

        admin.addProperty(new House("100 N 4th, Fairfiel, IA", 200));
        admin.addProperty(new Condominiums("10 N 3th, Fairfiel, IA", 4));
        admin.addProperty(new Condominiums("10 N 8th, Chicago, IL", 10));
        admin.addProperty(new House("104 N 5th, Fairfiel, IA", 100));
        admin.addProperty(new Trailers("TrailerPar Iowa, Fairfiel, IA"));
        admin.addProperty(new House("100 N 4th, New York, NY", 50));

        System.out.printf("\nTotal rent of all Properties %.2f \n",admin.computeTotalrent());

        System.out.println("\nAll properties by City of NY");
        admin.listAllPropertiesByCity("New York");
        System.out.println("\nAll properties by City of Fairfiel");
        admin.listAllPropertiesByCity("Fairfiel");
        System.out.println("\nAll properties by City of Chicago");
        admin.listAllPropertiesByCity("Chicago");
        System.out.println("\nAll properties");
        admin.listAllProperties();
    }
}
