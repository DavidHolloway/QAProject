package com.qa.menus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.qa.connection.DBcon;
import com.qa.main.Logic;
import com.qa.tables.Users;

public class UsersMenu {
	int userID = 0;
	DBcon connection = null;
	
	public UsersMenu(DBcon connPassed) {
		connection = connPassed;		
	}
		
	public void userMenu() {
		Users u = new Users(connection);
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		do {
		System.out.println("Please Select an option:\n1 - Create new user\n2 - View existing users\n3 - Update user information\n4 - Delete a user\n5 - Return");
		int op1 = sc.nextInt();
		System.out.println();
		sc.nextLine();
		switch (op1) {
		case 1:
			System.out.println("--------Create User--------");
			System.out.println("Please enter your desired username: ");
			String user = sc.nextLine();
			System.out.println("\nPlease enter a memorable password: ");
			String pass = sc.nextLine();
			System.out.println("\nPlease enter your first name: ");
			String fName = sc.nextLine();
			System.out.println("\nPlease enter your last name: ");
			String lName = sc.nextLine();
			u.createUser(userID, user, pass, fName, lName);
			break;
		case 2:
			u.readUser();
			break;
		case 3:
			boolean b = false;
			do {
			System.out.println("Please select what you would like to update:\n1 - Username"
					+ "\n2 - Password\n3 - First name\n4 - Last name\n5 - Return");
			int uu = sc.nextInt();
			System.out.println();
			sc.nextLine();
			switch (uu) {
			case 1:
				System.out.println("Please enter the ID of the user you would like to update: ");
				int id = sc.nextInt();
				System.out.println();
				sc.nextLine();
				System.out.println("Please enter a new username: ");
				String name = sc.nextLine();
				u.updateUserName(id, name);
				break;
			case 2:
				System.out.println("Please enter the ID of the user you would like to update: ");
				int id2 = sc.nextInt();
				System.out.println();
				sc.nextLine();
				System.out.println("Please enter the new password: ");
				String up = sc.nextLine();
				u.updateUserPass(id2, up);
				break;
			case 3:
				System.out.println("Please enter the ID of the user you would like to update: ");
				int id3 = sc.nextInt();
				System.out.println();
				sc.nextLine();
				System.out.println("Please enter the new first name: ");
				String fn = sc.nextLine();
				u.updateFname(id3, fn);
				break;
			case 4:
				System.out.println("Please enter the ID of the user you would like to update: ");
				int id4 = sc.nextInt();
				System.out.println();
				sc.nextLine();
				System.out.println("Please enter the new last name: ");
				String ln = sc.nextLine();
				u.updateFname(id4, ln);
				break;
			case 5:
				Logic l =Factory.getLogic(connection);
				l.run();
				break;
			default:
				System.out.println("Please enter a valid number");
				b=true;
				break;
			}
			}while(b==true);
		case 4:
			System.out.println("Please enter the userID you would like to delete: ");
			int idDel = sc.nextInt();
			u.deleteUser(idDel);
			break;
		case 5:
			Logic l =Factory.getLogic(connection);
			l.run();
			break;
		default:
			System.out.println("Please enter a valid number!\n");
			exit = true;
			break;
	}
		}while(exit == true);
	}

	

}

