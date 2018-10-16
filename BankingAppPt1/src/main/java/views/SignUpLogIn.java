package views;

import java.io.Serializable;
import java.util.Scanner;

import models.Admin;
import models.Bank;
import models.Customer;
import models.Employee;

public class SignUpLogIn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7792558825097595445L;
	
	
	Bank eclipseBank = new Bank();

	
	public void logIn(Scanner scanner) {
		System.out.println("");
		System.out.println("What kind of user are you signing in as?");
		System.out.println("(1) Customer");
		System.out.println("(2) Employee");
		System.out.println("(3) Administrator");
		System.out.println("(0) Go back to previous menu");
		System.out.println("");

		String s = scanner.nextLine();

		try {
			SignUpLogIn login = new SignUpLogIn();
			int S = Integer.valueOf(s);
			switch (S) {
			case 0:
				//Back to the previous menu
				System.out.println("Going back to previous menu");

				Launcher UI = new Launcher();
				UI.Initialize(scanner);
				break;
				
			case 1:
//				eclipseBank.getCustomerList();
//				System.out.println(eclipseBank.customerList);

				//Sign in as Customer
				System.out.println("");

				System.out.println("Enter customer username:");
				String cUsername = scanner.nextLine();
				String cUn = cUsername.toLowerCase();

				System.out.println("Enter customer password:");
				String cPassword = scanner.nextLine();
				String cPw = cPassword.toLowerCase();

				Customer C = eclipseBank.getCustomerUsingPass(cUn, cPw);
				if (eclipseBank.customerList.contains(C)) {
					System.out.println("");
					System.out.println("You have successfully signed in as customer: ");
					// function to go to Customer Menu
					CustomerMenu cMenu = new CustomerMenu();
					cMenu.customerMenu(C, scanner);
					break;

				} else
					System.out.println("ERROR - Customer does not exist! Invalid username and password. Try again.");
				System.out.println("");
				login.logIn(scanner);
				break;

			case 2:
				//Sign in as Employee
				System.out.println("");
				System.out.println("Enter employee username:");
				String eUsername = scanner.nextLine();
				String eUn = eUsername.toLowerCase();
				System.out.println("Enter employee password:");
				String ePassword = scanner.nextLine();
				String ePw = ePassword.toLowerCase();

				Employee E = eclipseBank.getEmployeeUsingPass(eUn, ePw);
				if (eclipseBank.employeeList.contains(E)) {
					System.out.println("");
					System.out.println("You have successfully signed in as an employee: ");

					// function to go to Employee Menu
					break;
				} else
					System.out.println("ERROR - Employee does not exist! Invalid username and password. Try again.");
				System.out.println();
				login.logIn(scanner);
				break;

			case 3:
				//Sign in as Admin
				System.out.println("");
				System.out.println("Enter administrator username:");
				String aUsername = scanner.nextLine();
				String aUn = aUsername.toLowerCase();
				System.out.println("Enter administrator password:");
				String aPassword = scanner.nextLine();
				String aPw = aPassword.toLowerCase();

				Admin A = eclipseBank.getAdminUsingPass(aUn, aPw);
				if (eclipseBank.adminList.contains(A)) {
					System.out.println("");
					System.out.println("You have successfully signed in as an administrator: ");

					// function to go to Admin Menu
					break;
				} else
					System.out
							.println("ERROR - Administrator does not exist! Invalid username and password. Try again.");
				System.out.println();
				login.logIn(scanner);
				break;
			default:
				System.out.println("ERROR - Your input was invalid. Please try again");
				System.out.println();
				login.logIn(scanner);
			}
		} catch (NumberFormatException e) {
			System.out.println("ERROR - Your input was invalid. Please try again");
			System.out.println();
			SignUpLogIn login = new SignUpLogIn();
			login.logIn(scanner);
		}

	}

	public void createAccount(Scanner scanner) {
		System.out.println("");

		System.out.println("To create an account start by entering your first name.");
		String firstname = scanner.nextLine();
		String fn = firstname.toLowerCase();

		System.out.println("Enter your last name.");
		String lastname = scanner.nextLine();
		String ln = lastname.toLowerCase();

		System.out.println("Enter your username for your log in.");
		String username = scanner.nextLine();
		String un = username.toLowerCase();

		System.out.println("Enter your password for your log in.");
		String password = scanner.nextLine();
		String pw = password.toLowerCase();

		Customer C = new Customer(fn, ln, un, pw);
		Customer foundSame = eclipseBank.getCustomerUsingUsername(un);

		if (foundSame != null) {
			System.out.println("Please choose a new username, it appears to have already been taken");
			System.out.println("You have been returned to account creation.");
			createAccount(scanner);
		} else {
		
			eclipseBank.customerList.add(C);
			System.out.println(eclipseBank.customerList);


			System.out
					.println("Thank you, " + fn + " " + ln + " you have successfully created a new customer account.");
			System.out.println("Your username is: " + un + " and your password is: " + pw);
			System.out.println("You may now log in.");
			System.out.println("");
			
			// serialize the arraylist with save

			SignUpLogIn LogIn = new SignUpLogIn();
			LogIn.logIn(scanner);
		}
	}
}
