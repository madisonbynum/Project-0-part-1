package views;

import java.io.Serializable;
import java.util.Scanner;

import models.Bank;
import persistency.SerialBank;

public class Launcher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3753387934805763747L;
	
	public static SerialBank sbank= new SerialBank();
	
	

	public void Initialize(Scanner scanner) {
		System.out.println("Would you like to Sign in or Create an Account with us today?");
		System.out.println("(1) - Sign in ");
		System.out.println("(2) - Create an Account");
		System.out.println("(0) - Exit the program ");

		String s = scanner.nextLine();

		try {
			int S = Integer.valueOf(s);
			switch (S) {
			case 0:
				System.out.println("Goodbye");
				break;
			case 1:
				SignUpLogIn LogIn = new SignUpLogIn();
				LogIn.logIn(scanner);
				break;
			case 2:
				SignUpLogIn SignUp = new SignUpLogIn();
				SignUp.createAccount(scanner);
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

	public static void main(String[] args) {
		
		//Start of initialize a new instance of Launcher
		// Initialize a new launcher so that all my methods don't
		//become static
		Launcher UserI;
		Bank eclipseBank = new Bank();
	
		sbank.loadSerializeMyBank();
		
		UserI = SerialBank.launcher;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Hi, Welcome to Eclipse Bank");
		System.out.println("");
		System.out.println(eclipseBank.customerList);
		UserI.Initialize(scanner);
	}
}
