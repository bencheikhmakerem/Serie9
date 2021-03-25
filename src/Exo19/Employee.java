package Exo19;

import java.util.Objects;

public class Employee extends Person {
	
	int Salary;

	public Employee(String lastName, String firstName, int age, int salary) {
		super(lastName, firstName, age);
		Salary = salary;
	}

	public Employee(String lastName, String firstName, int age) {
		
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Salary == other.Salary;
	}

	@Override
	public String toString() {
		return "Employee [Salary=" + Salary + "]";
	}
	
	
	

}
