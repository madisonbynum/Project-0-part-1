package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1459493763151194758L;

	/**
	 * Fields
	 */

	private String accountName;
	private float balance;
	private ArrayList<String> accountHolders;
	private Status status;

	// Created enumerated data type for status
	public enum Status {
		PENDING, ACTIVE, ClOSED;
	}

	// Constructors

	// This constructor is called when more than one owner is trying to create an
	// account
	public Account(ArrayList<String> accountHolders, String accountName, long accountID) {
		this.accountHolders = accountHolders;
		this.accountName = accountName;
		this.balance = 0.00f;
		this.status = Status.PENDING;
	}

	// This constructor is called when ONE person is trying to create an account
	public Account(String accountOwner, String accountName, long accountID) {
		this.accountHolders = new ArrayList<String>();
		this.accountHolders.add(accountOwner);
		this.accountName = accountName;
		this.balance = 0.00f;
		this.status = Status.PENDING;
	}

	/**
	 * Methods
	 */

	public boolean withdraw(float wAmount) {

		// If statement to check if the account is active
		//Cannot withdraw from a pending or closed account
		if (this.status != Status.ACTIVE) {
			System.out.println("ERROR - The account has NOT yet been approved. Cannot withdraw from account: " + this.accountName 
					+ "/n" + " Please wait until an employee or Admin to change your account status. ");
			return false;
		}
		
		//Do not allow a negative withdraw amount
		if (wAmount < 0.00f) {
			System.out.println("ERROR - You are trying to withdraw a negative value from account: " + this.accountName);
			System.out.println("Please try again with a different amount. ");
			return false;
			
		//Do not allow for a withdrawal greater than balance
		} else if (wAmount > this.balance) {
			System.out.println("ERROR - The amount you are trying to withdraw is greater than what is available in account: "
							+ this.accountName);
			System.out.println("Please try again. ");
			return false;
			
		//Successful attempt to withdraw
		} else if (wAmount < this.balance) {
			this.balance -= wAmount;
			
			System.out.printf(": $ " + "%.2f", wAmount + "has successfully been withdrawn from account: "
					+ this.accountName);
			System.out.println();
			System.out.printf("Your current balance in account:" + this.accountName + "is : $ " + "%.2f", this.balance);
			System.out.println();
//			banklogger
			return true;
		}
		
		//In case something went wrong?
		System.out.println("ERROR - Unexpected error while withdrawing from account: " + this.accountName);
		return false;
	}

	// generate getters and setters

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public ArrayList<String> getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(ArrayList<String> accountHolders) {
		this.accountHolders = accountHolders;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	// Generate to-string
	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", balance=" + balance + ", accountHolders=" + accountHolders
				+ ", status=" + status + "]";
	}

}