package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5937556716373923609L;
	
	
	public ArrayList<Customer> customerList;
	public ArrayList<Employee> employeeList;
	public ArrayList<Admin> adminList;

	
	//Constructor of Bank and basic Customer, Employee, and Administrator
	//for testing
	public Bank() {

		customerList = new ArrayList<Customer>();
		Customer C = new Customer("madison", "bynum", "madb", "123");
		
		customerList.add(C);
		employeeList = new ArrayList<Employee>();
		Employee E = new Employee("madi", "by", "madib", "1234");
		employeeList.add(E);
		adminList = new ArrayList<Admin>();
		Admin A = new Admin("amber", "stone", "amberstone195", "12345");
		adminList.add(A);
	}

	//getters and setter for the array lists
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public ArrayList<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(ArrayList<Admin> adminList) {
		this.adminList = adminList;
	}

	//Generated To-string for bank
	@Override
	public String toString() {
		return "Bank [customerList=" + customerList + ", employeeList=" + employeeList + ", adminList=" + adminList
				+ "]";
	}

	//These functions find a customer using specific parameters
	public Customer getCustomer(String firstName, String lastName, String username, String password) {
		for (Customer C : customerList) {
			if (C.getFirstname().equals(firstName) && C.getLastname().equals(lastName)
					&& C.getUsername().equals(username) && C.getPassword().equals(password))
				return C;
		}
		return null;
	}
	public Customer getCustomerUsingNames(String firstName, String lastName) {
		for (Customer C : customerList) {
			if (C.getFirstname().equals(firstName) && C.getLastname().equals(lastName))
				return C;
		}
		return null;
	}

	public Customer getCustomerUsingPass(String username, String password) {
		for (Customer C : customerList) {
			if (C.getUsername().equals(username) && C.getPassword().equals(password))
				return C;
		}
		return null;
	}
	
	public Customer getCustomerUsingUsername(String username) {
		for(Customer C:customerList) {
			if(C.getUsername().equals(username) )
				return C;
		}
		return null;
	}

	//Finds an employee in the arraylist for log in purposes
	public Employee getEmployeeUsingPass(String username, String password) {
		for (Employee E : employeeList) {
			if (E.getUsername().equals(username) && E.getPassword().equals(password))
				return E;
		}
		return null;
	}
	
	//Finds an admin in the arraylist for log in purposes
	public Admin getAdminUsingPass(String username, String password) {
		for (Admin A : adminList) {
			if (A.getUsername().equals(username) && A.getPassword().equals(password))
				return A;
		}
		return null;
	}

}