package views;

import java.io.Serializable;
import java.util.Scanner;

public class Launcher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3753387934805763747L;
	

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
		Scanner scanner = new Scanner(System.in);

//		ArrayList<Customer> CList = new ArrayList<Customer>();
//		Customer C = new Customer("luis", "doi", "ldoi", "111");
//		Customer C2 = new Customer("luis", "doi", "ldoi", "111");
//		Customer C3 = new Customer("luis", "doi", "ldoi", "222");
//		CList.add(C);
//
//		System.out.println(CList.contains(C));
//		System.out.println(CList.contains(C2));
//		System.out.println(CList.contains(C3));
//
//		for (Customer c : CList) {
//			if (c.getFirstname().equals("luis"))
//				System.out.println("success. found luis");
//
//		}

		// Initialize a new launcher so that all my methods don't
		// have to be static now!
		Launcher UI = new Launcher();

		System.out.println("Hi, Welcome to Eclipse Bank");
		System.out.println("");
		UI.Initialize(scanner);
	}
}
