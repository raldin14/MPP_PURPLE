package lesson7.labs.prob1.partB;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
	private String name;
	private int salary;
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override 
	public String toString() {
		return "(" + name + ", " + salary + ")";
	}
	
//	public boolean equals(Employee e) {
//
//		return e.name.equals(name) && e.salary == salary;
//	}

	/**
	 * Solution for partB
	 * Corrected equals method
	 * */
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return  false;
		if(!(ob instanceof Employee e)) return  false;
        return  e.name.equals(name) && e.salary == salary;
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, salary);
	}

	//	public boolean equals(Object ob) {
//		Employee e = (Employee)ob;
//		return e.name.equals(name) && e.salary == salary;
//	}
}
