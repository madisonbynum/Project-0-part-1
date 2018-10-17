package models;

import java.io.Serializable;
import java.util.Scanner;

public class Admin extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2648934593196759994L;

	// Constructor inherited from User
		public Admin(String firstname, String lastname, String username, String password) {
			super(firstname, lastname, username, password);
			
		}

	// Generated to string for admin
	@Override
	public String toString() {
		return "Admin [firstname=" + getFirstname() + ", lastname=" + getLastname() + ", username=" + getUsername()
				+ ", password=" + getPassword() + "]";
	}

	//Admins can overide, but i'm waiting to do this
	@Override
	public boolean withdraw(Scanner scanner) {
		return false;
		// TODO Auto-generated method stub

	}

}