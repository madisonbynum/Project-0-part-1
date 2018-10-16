package models;

import java.io.Serializable;
import java.util.Scanner;

public class Employee extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1912100280293285137L;

	// Constructor inherited from User
	public Employee(String firstname, String lastname, String username, String password) {
		super(firstname, lastname, username, password);
	
	}

	// Generated to string for employee
	@Override
	public String toString() {
		return "Employee [firstname=" + getFirstname() + ", lastname=" + getLastname() + ", username=" + getUsername()
				+ ", password=" + getPassword() + "]";
	}

	// Employees cannot withdraw, but this method was inherited from User
	@Override
	public boolean withdraw(Scanner scanner) {
		return false;
	}

}
