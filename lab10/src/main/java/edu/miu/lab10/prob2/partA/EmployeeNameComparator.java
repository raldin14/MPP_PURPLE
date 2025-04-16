package edu.miu.lab10.prob2.partA;


import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {

		//checks if  names are the same if not then return the comapre right away
		int nameCompare = e1.name.compareTo(e2.name);
		if(nameCompare !=0) return nameCompare;

		// we continue to compare salary
		return Integer.compare(e1.salary, e2.salary);
	}
}
