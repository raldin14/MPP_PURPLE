package edu.miu.lab10.prob2.B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeInfo {
    static enum SortMethod {BYNAME, BYSALARY}
    public void sort(List<Employee> emps, final SortMethod method) {
        class EmployeeComparator implements Comparator<Employee> {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (method == SortMethod.BYNAME) {
                    int nameComp = e1.name.compareTo(e2.name);
                    if(nameComp !=0) return nameComp;
                    //fall back to salary
                    return  Integer.compare(e1.salary, e2.salary);

                } else {
                    int salaryComp = Integer.compare(e1.salary, e2.salary);
                    if(salaryComp != 0) return salaryComp;
                    // fallback to name
                    return e1.name.compareTo(e2.name);
                }
            }
        }
        Collections.sort(emps, new EmployeeComparator());
    }

    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Joe", 100000));
        emps.add(new Employee("Tim", 50000));
        emps.add(new Employee("Andy", 60000));
		emps.add(new Employee("Zere", 70000));
		emps.add(new Employee("Zere", 60000));

        emps.add(new Employee("Kim", 50000));
        emps.add(new Employee("Reny", 60000));
        EmployeeInfo ei = new EmployeeInfo();
        ei.sort(emps, EmployeeInfo.SortMethod.BYNAME);
        System.out.println(emps);
        //same instance
        ei.sort(emps, EmployeeInfo.SortMethod.BYSALARY);
        System.out.println(emps);
    }
}
