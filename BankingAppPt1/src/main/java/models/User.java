package models;

import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = -8374191857782105954L;
	
	
		// fields for Customer, Admin, and Employee
		private String firstname;
		private String lastname;
		private String username;
		private String password;
		
		
	

		// constructor for Customer, Admin, and Employee
		public User(String firstname, String lastname, String username, String password) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.username = username;
			this.password = password;
		
		}
		
		//Abstract Methods
		public abstract boolean withdraw(Scanner scanner);
		
		//getters and setter for Customer, Admin, and Employee

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		//To String for parent class User
		@Override
		public String toString() {
			return "User [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
					+ password + "]";
		}

		
		
		
		
		
}
