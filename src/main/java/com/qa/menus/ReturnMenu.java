package com.qa.menus;

import java.util.Scanner;

import com.qa.connection.DBcon;
import com.qa.main.Logic;

public class ReturnMenu {
	Scanner sc = new Scanner(System.in);
	DBcon connection = null;
	
	public ReturnMenu(DBcon connPassed) {
		connection = connPassed;				
	}

//	public void returnMenu() {
//		//stem.out.println("\nPress enter to return to menu...");
//		//.nextLine();
//		Logic l = new Logic(connection);
//		l.run();
//	}
	// factories - making new version

	public void checkInt() {
		while (!sc.hasNextInt()) {
			System.out.println("That's not a number!\n");
			sc.next(); // this is important!
			Logic l = new Logic(connection);
			l.run();
			
		}
	}

}
