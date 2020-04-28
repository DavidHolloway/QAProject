package com.qa.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.qa.connection.DBcon;
import com.qa.menus.OrdersMenu;
import com.qa.menus.ProductsMenu;
import com.qa.menus.ReturnMenu;
import com.qa.menus.UsersMenu;

public class Logic {

	int userID = 0;
	int productID = 0;
	int orderID = 0;
	DBcon connection = null;
	
	public Logic(DBcon connectionPassed) {
		connection = connectionPassed;
	}
	
	ReturnMenu rm = new ReturnMenu(connection);

	public void run() {
	boolean exit = false;
	boolean bool = false;
	do {

	Scanner sc = new Scanner(System.in);	
		exit = false;
		System.out.println("Please Select One Of The Following Tables:\n1 - Users\n2 - Products\n3 - Orders\n4 - Exit");	
		//rm.checkInt();
		int table = sc.nextInt();
		System.out.println();
		sc.nextLine();

				
		switch (table) {
		case 1:
				UsersMenu um = new UsersMenu(connection);
				um.userMenu();	
				break;
		case 2:
				ProductsMenu pm = new ProductsMenu(connection);
				pm.productMenu();
				break;
		case 3:
				OrdersMenu om = new OrdersMenu(connection);
				om.orderMenu();
				break;
		case 4:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
				//exit = false;
		default:
			System.out.println("Invalid option, try again!\n");
			exit = true;
			break;
		}
	
	
	}while(exit == true);
	}
}
