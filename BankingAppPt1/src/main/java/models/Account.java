package models;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Account implements Serializable {
	
	Bank eclipseBank = new Bank();

	
//	ArrayList<Customer> CList = new ArrayList<Customer>();
//	Customer C = new Customer("luis", "doi", "ldoi", "111");
//	Customer C2 = new Customer("luis", "doi", "ldoi", "111");
//	Customer C3 = new Customer("luis", "doi", "ldoi", "222");
//	CList.add(C);
//
//	System.out.println(CList.contains(C));
//	System.out.println(CList.contains(C2));
//	System.out.println(CList.contains(C3));
//
//	for (Customer c : CList) {
//		if (c.getFirstname().equals("luis"))
//			System.out.println("success. found luis");
//
//	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1459493763151194758L;

	/**
	 * Fields
	 */

	private String accountName;
	private float balance;
	private ArrayList<String> accountOwners;
	private Status status;
	private long accountNumber;
	private String accountOwner;

	// Created enumerated data type for status
	public enum Status {
		PENDING, ACTIVE, CLOSED;
	}

	// Constructors

	// This constructor is called when more than one owner is trying to create an
	// account
	public Account(ArrayList<String> accountOwners, String accountName, long accountID) {
		this.accountOwners = accountOwners;
		this.accountName = accountName;
		this.balance = 0.00f;
		this.status = Status.PENDING;
	}

	// This constructor is called when ONE person is trying to create an account
	public Account(String accountOwner, String accountName, long accountID) {
		this.accountOwner= accountOwner;
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

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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

	public ArrayList<String> getAccountOwners() {
		return accountOwners;
	}

	public void setAccountOwners(ArrayList<String> accountHolders) {
		this.accountOwners = accountHolders;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", balance=" + balance + ", accountOwners=" + accountOwners
				+ ", status=" + status + ", accountNumber=" + accountNumber + "]";
	}

//	public void applyForChecking(Customer C, Scanner scanner){
//		Customer customer = new Customer("","","","");
//		System.out.println(C.getFirstname()+ " " + C.getLastname() +", you are +"
//				+ "attempting to apply for a checking account.");
//		String s = scanner.nextLine();
//		if(C.findAccount(C) == null) {
//			long accountID = genRandomIDNum(10L);
//			long tempAcctID = genRandomIDNum(accountID);
//			new Account(C.getUsername(),"Checking", tempAcctID);
//			customer.account.setAccountOwner(C.getUsername());
//			customer.account.setAccountName("Checking");
//			customer.account.setAccountNumber(tempAcctID);
//			System.out.println(eclipseBank.customerList);
//		}
//		}
	

	public void applyForJoint(Customer C, Scanner scanner) {

	}

	public ArrayList<Account> getAccounts(ArrayList<String> accountOwners2, String accountName2, long accountNumber2) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	public boolean changeStatusToACTIVE() {
		this.status = Status.ACTIVE;
		return true;
	}
	
	public boolean changeStatusToCLOSED() {
		this.status = Status.CLOSED;
		return true;
	}
	
//	public static long genRandomIDNum(long accountID) {
//		Random rand = new Random(); 
//		long rand1;
//		long rand2;
//		long randomV;
//		while(true) {
//			rand1 = rand.nextInt(100000000);
//	        rand2 = rand.nextInt(100000000);
//	        randomV = rand1 * rand2;
//	        // check if it already exists
//	        if(accountID!=randomV)
//	        	break;
//		}
//        return randomV;
//	}

}

