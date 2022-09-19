package com.luv2code.practice;
import java.util.Arrays;
import java.util.List;

public class SimpleHashtable {
	StoredEmployee[] employees;
	
	public SimpleHashtable() {
		employees = new StoredEmployee[10];
	}
	
	int hashkey(String key) {
		return key.length() % employees.length;
	}
	
	int findKey(String key) {
		int 	hashkey = hashkey(key);
		int stopIndex = hashkey;
		if(employees[hashkey] != null && employees[hashkey].key.equals(key)) {
			return hashkey;
		}

		while(employees[hashkey] != null) {
			if(hashkey == employees.length-1) {
				hashkey=0;
			}else {
				hashkey++;
			}
			if(employees[hashkey] != null &&employees[hashkey].key.equals(key)) {
				return hashkey;
			}
			if(hashkey == stopIndex) {
				System.out.println("No Empty postion found");
				break;
			}
		}	
		
		return -1;
	}
	
	void add(String key, Employee employee) throws Exception {
		int hashkey = hashkey(key);
		int stopIndex = hashkey;

		while(occupied(hashkey)) {
			if(hashkey == employees.length-1) {
				hashkey=0;
			}else {
				hashkey++;
			}
			if(hashkey == stopIndex) {
//				System.out.println("No Empty postion found");
				break;
			}
		}	
		employees[hashkey] = new StoredEmployee(key, employee);
	}
	
	StoredEmployee get(String key) {
		int hashkey=  findKey(key);
		if(hashkey==-1) {
			return null;
		}
		return employees[hashkey];
	}
	
	boolean occupied(int hashkey) {
		return employees[hashkey] != null;	
	}
	
	void remove(String key) {
		int hashkey = hashkey(key);
		List<StoredEmployee> tempEmps = Arrays.asList(employees);
		tempEmps.remove(hashkey);
		employees = (StoredEmployee[]) tempEmps.toArray();		
	}
	
	void print() {
		Arrays.stream(employees).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		Employee emp1 = new Employee("Mohsin", "ejaz");
		Employee emp2 = new Employee("Asif", "ejaz");
		Employee emp3 = new Employee("mejazbese21", "ejaz");
		Employee emp4 = new Employee("Kamran", "ejaz");
		Employee emp5 = new Employee("HassanS", "ejaz");

		SimpleHashtable simpleHashtableImpl = new SimpleHashtable();
		try {
			// note that hashkey depends on the lengths
			simpleHashtableImpl.add("k66", emp1);
			simpleHashtableImpl.add("k11", emp2);
			simpleHashtableImpl.add("k22", emp3);
			simpleHashtableImpl.add("k33", emp4);
			simpleHashtableImpl.add("k44", emp5);
			simpleHashtableImpl.add("k21", emp5);
			simpleHashtableImpl.add("k31", emp5);
			simpleHashtableImpl.add("k23", emp5);
			simpleHashtableImpl.add("k24", emp5);
			simpleHashtableImpl.add("k25", emp5);
			simpleHashtableImpl.add("k26", emp5);
			simpleHashtableImpl.add("k27", emp5);
			
//			simpleHashtableImpl.print();
			
			System.out.print(simpleHashtableImpl.get("k25"));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

class Employee {
	String firstName;
	String lastName;
	
	public Employee(String firstName, String lastName) {
		this.firstName= firstName;
		this.lastName=lastName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}

class StoredEmployee{
	String key;
	Employee employee;
	public StoredEmployee(String key, Employee employee) {
		super();
		this.key = key;
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "StoredEmployee [key=" + key + ", employee=" + employee + "]";
	}
	
	
	
}