#### The issue in Part B is due to the incorrect implementation of the equals() method in the Employee class.
#### The method currently defined is:

```
public boolean equals(Employee e) {
return e.name.equals(name) && e.salary == salary;
}
```

- This method overloads equals instead of overriding it. Java collections such as List use the equals(Object obj) method to determine equality between objects. Since equals(Employee e) does not override Object's equals method, methods like List.contains() and List.remove() fall back to comparing object references instead of content.

- To fix this, equals(Object obj) should be overridden properly, and hashCode() should also be implemented:

```@Override
public boolean equals(Object obj) {
if (this == obj) return true;
if (obj == null || getClass() != obj.getClass()) return false;
Employee employee = (Employee) obj;
return salary == employee.salary && name.equals(employee.name);
}
```
```
@Override
public int hashCode() {
return Objects.hash(name, salary);
}
```
