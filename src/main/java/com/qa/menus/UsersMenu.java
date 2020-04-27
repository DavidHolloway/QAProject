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
	
	
	
	public void userMenu() {
		Users u = new Users();
		//DBcon db = new DBcon();
		Scanner sc = new Scanner(System.in);

		//db.connect();
		System.out.println("Please Select an option: Create[1], Read[2], Update[3], Delete[4] Return[5]");
		int op1 = sc.nextInt();
		System.out.println();
		sc.nextLine();
		switch (op1) {
		case 1:
			System.out.println("--------Create User--------");
			System.out.println("Please enter your username:");
			String user = sc.nextLine();
			System.out.println("\nPlease enter a password:");
			String pass = sc.nextLine();
			System.out.println("\nPlease enter your first name:");
			String fName = sc.nextLine();
			System.out.println("Please enter your last name:\n");
			String lName = sc.nextLine();
			u.createUser(userID, user, pass, fName, lName);
			break;
		case 2:
			u.readUser();
//			System.out.println("Press enter to return to menu");
//			sc.nextLine();
//			Logic l = new Logic();
//			l.run();
			break;
		case 3:
			System.out.println("Please enter your userID: ");
			int id = sc.nextInt();
			System.out.println();
			sc.nextLine();
			System.out.println("\nPlease enter the new username: ");
			String name = sc.nextLine();
			u.updateUser(id, name);
			break;
		case 4:
			System.out.println("Please enter your userID: ");
			int idDel = sc.nextInt();
			u.deleteUser(idDel);
			break;
		case 5:
			Logic lg = new Logic();
			lg.run();
			break;
		default:
			System.out.println("Please enter a valid number");
			break;
	}
	}

	

}

