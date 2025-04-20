package edu.miu.lab11.part2.prob11;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final Function<List<Employee>, String> FILTER_SORT_COLLECT = emps ->
            emps.stream()
                    .filter(e -> e.getSalary() > 100000)
                    .filter(e -> e.getLastName().compareTo("N") >= 0 && e.getLastName().compareTo("Z") <= 0)
                    .map(Employee::fullName)
                    .sorted()
                    .collect(Collectors.joining(", "));
}
