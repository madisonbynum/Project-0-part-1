package views;

import java.io.Serializable;
import java.util.Scanner;

import models.Bank;
import models.Customer;

public class CustomerMenu implements Serializable {

	/**
	 * 
	 */
	
	Bank eclipseBank = new Bank();
	SignUpLogIn login;

		public void customerMenu(Customer C, Scanner scanner) {
			System.out.println("");
			System.out.println("Welcome to the Customer Menu!");
			System.out.println("What would you like to do?");
			System.out.println("(1) Apply for an account");
			System.out.println("(2) View all accounts and balances");
			System.out.println("(3) Withdraw");
			System.out.println("(4) Deposit");
			System.out.println("(5) Transfer");
			System.out.println("(0) Exit the program");
	
			String s = scanner.nextLine();
			
			try {
				CustomerMenu customerMenu = new CustomerMenu();
				Customer customer = new Customer("","","","");
				
				int S = Integer.valueOf(s);
				switch (S) {
				case 0:
					System.out.println("Goodbye");
					break;
				case 1:
					//Apply for an account
					System.out.println("What account would you like to apply for?");
					System.out.println("(1) Checking account");
					System.out.println("(2) Joint account");
					System.out.println("(3) Go back");
					String x = scanner.nextLine();
					
						if(x.equals("1")) {
						customer.applyForChecking(C, scanner);
						break;
						}
						else if(x.equals("2")) {
						customer.applyForJoint(C, scanner);
						break;
						}
						else if(x.equals("3")) {
						customerMenu.customerMenu(C, scanner);
						break;
						}
						else
							System.out.println("Invalid selection - try again");
						System.out.println(eclipseBank.customerList.contains(C));
						System.out.println();
						customerMenu.customerMenu(C, scanner);
					break;
				case 2:
					//View all accounts and balances
					break;
				case 3:
					
					break;
				case 4:
					//Deposit
					break;
				case 5:
					//Transfer
					break;
				default:
					System.out.println("ERROR - Your input was invalid. Please try again");
					System.out.println();
					Launcher UI = new Launcher();
					UI.Initialize(scanner);
				}
			} catch (NumberFormatException e) {
				System.out.println("ERROR - Your input was invalid. Please try again");
				System.out.println();
				Launcher UI = new Launcher();
				UI.Initialize(scanner);
			}
		}
}