
# Why Use the `Compensable` Interface in a Payroll?

In a well-designed payroll system, we should focus on **behavior**, not implementation details. The `Compensensable` interface captures the idea that **any object that can be paid** should provide a way to calculate its compensation.

---

```java
public interface Compensable {
    Paycheck calcCompensation(int month, int year);
    void print();
}
```

Any class that implements this interface can be part of the payroll system. For example:

- Hourly employees
- Salaried employees
- Commissioned employees
- Contractors
- Freelancers

---

## Real-World

> Think like the Finance Department.  
> You don’t care how someone is paid — you just need:
>
> - A name
> - A paycheck
>
> If a person can give you that, you’ll pay them.
---

## ✅ What Problem Does It Solve?

Without the interface, your system would depend on a fixed `Employee` class hierarchy. But what if you later need to add:

- A `Contractor`
- A `TemporaryWorker`
- A `Freelancer`?

You’d either have to:

- Force them to extend `Employee` (even if it doesn't make sense), **or**
- Rewrite a lot of your business logic

With `Compensable`, you don’t have that problem. Just implement the interface and plug the class into your system — no changes to existing logic required.

---

## Java Code Example

### ✅ Employee (abstract)

```java
public abstract class Employee implements Compensable {
    protected String empId;

    public Employee(String empId) {
        this.empId = empId;
    }

    public Paycheck calcCompensation(int month, int year) {
        double gross = calcGrossPay(month, year);
        return new Paycheck(gross, 0.23 * gross, 0.05 * gross, 0.01 * gross, 0.03 * gross, 0.075 * gross);
    }

    public void print() {
        System.out.println("Employee ID: " + empId);
    }

    protected abstract double calcGrossPay(int month, int year);
}
```

---

### ✅ Hourly Employee

```java
public class Hourly extends Employee {
    private double hourlyWage;
    private double hoursPerWeek;

    public Hourly(String empId, double hourlyWage, double hoursPerWeek) {
        super(empId);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    protected double calcGrossPay(int month, int year) {
        return hourlyWage * hoursPerWeek * 4;
    }
}
```

---

### ✅ Contractor (Not an Employee! Suppose this person is me.)

```java
public class Contractor implements Compensable {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public Contractor(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public Paycheck calcCompensation(int month, int year) {
        double gross = hourlyRate * hoursWorked;
        return new Paycheck(gross, 0, 0, 0, 0, 0); // simplified: no taxes for me
    }

    public void print() {
        System.out.println("Contractor: " + name);
    }
}
```

---

### ✅ Unified Payroll Processing

```java
public class PayrollApp {
    public static void main(String[] args) {
        Compensable emp1 = new Hourly("H001", 25.0, 40);
        Compensable emp2 = new Contractor("DylanSong", 100.0, 30);

        List<Compensable> payees = List.of(emp1, emp2);

        for (Compensable c : payees) {
            c.print();
            c.calcCompensation(4, 2025).print();
        }
    }
}
```
> Design for behavior, not for specific types.  
> `Compensable` makes this payroll future-proof, flexible, and clean.
