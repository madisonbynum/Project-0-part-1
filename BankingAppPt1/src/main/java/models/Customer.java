package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 988991762105053770L;

	// fields related only to Customer
	private ArrayList<Account> accounts = new ArrayList<Account>();
	Account account = new Account ("", "", 0);
s
	// Constructor inherited from User with added field
	// initialize ArrayList<Account>

	public Customer(String firstname, String lastname, String username, String password) {
		super(firstname, lastname, username, password);
//		this.accounts = new ArrayList<Account>();

	}

	// getters and setter for arrayList
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	


	// generate to-string for Customer. generating getters and setters in User, then
	// putting it in here
	// with getfield();
	@Override
	public String toString() {
		return "Customer [firstname=" + getFirstname() + ", lastname=" + getLastname() + ", Username=" + getUsername()
				+ ", password=" + getPassword() + ", accounts=\" + accounts + \"]";
	}

//	@Override
//	public boolean withdraw(Scanner scanner) {
//		if (activeAccounts()) {
//			System.out.println("Which account would you like to withdraw from?");
//			String x = scanner.nextLine();
//			// Anything inputed will be changed to all lowercase to match arraylist
//			String y = x.toLowerCase();
//			Account A = findAccount(y);
//			if (A != null) {
//				System.out.println("How much would you like to withdraw?");
//				float wAmount = Float.valueOf(scanner.nextLine());
//				if (A.withdraw(wAmount))
//					return true;
//				else
//					return false;
//			} else
//				return false;
//		}
//		return false;
//
//	}
//	public Account findAccount(String s) {
//		Customer customer = new Customer("", "", "", "");
//		if(customer.accounts.isEmpty()) {
//			System.out.println("Sorry, but you do not have any active accounts.");
//			return null;
//		}
//		for (Account A : customer.accounts) {
//			if (A.getAccountName().contains(s))
//				return A;
//		}
//		return null;
//	}
//
//	public Account findAccount(Customer C) {
//		Customer customer = new Customer("", "", "", "");
//		String U = C.toString();
//		if (customer.accounts.isEmpty()) {
//			System.out.println("Sorry, but you do not have any active accounts.");
//			return null;
//		}
//		for (Account A : customer.accounts) {
//			if (customer.account != null)
//				return A;
//		}
//		return null;
//	}

	public boolean activeAccounts() {
		if (accounts.isEmpty()) {

			System.out.println("Sorry, but you do not have any active accounts.");
			return false;
		} else {
			for (Account A : accounts) {
				System.out.printf(A.getAccountName() + ": $ " + "%.2f", A.getBalance());
				System.out.println();
			}
			return true;
		}
	
	}

	@Override
	public boolean withdraw(Scanner scanner) {
		// TODO Auto-generated method stub
		return false;
	}}
	
