package edu.miu.lab3.prob1;

public class PersonWithJob {
    private Person person;

    private double salary;

    PersonWithJob(String name, double salary) {
        this.person = new Person(name);
        this.salary = salary;
    }

    public String getName() {
        return person.getName();
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PersonWithJob)) return false;
        PersonWithJob other = (PersonWithJob) obj;
        return this.getName().equals(other.getName()) &&
                this.getSalary() == other.getSalary();
    }

    public static void main(String[] args) {
        PersonWithJob p1 = new PersonWithJob("Haining", 30000);
        PersonWithJob p2 = new PersonWithJob("Haining", 30000);
        System.out.println("p1.equals(p2)? " + p1.equals(p2)); // true
        System.out.println("p2.equals(p1)? " + p2.equals(p1)); // true
    }
}
