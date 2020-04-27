package com.qa.main;

import java.util.Scanner;

import com.qa.menus.OrdersMenu;
import com.qa.menus.ProductsMenu;
import com.qa.menus.UsersMenu;

public class Logic {

	int userID = 0;
	int productID = 0;
	int orderID = 0;

	public void run() {
	boolean exit = false;
	do {

	Scanner sc = new Scanner(System.in);	
		exit = false;
		System.out.println("Please select a table:\nUsers[1] Products[2] Orders[3] Exit[4]\n");
		int table = sc.nextInt();
		System.out.println();
		sc.nextLine();
				
		switch (table) {
		case 1:
				UsersMenu um = new UsersMenu();
				um.userMenu();	
				exit = true;
				break;
		case 2:
				ProductsMenu pm = new ProductsMenu();
				pm.productsMenu();
				exit = true;
				break;
		case 3:
				OrdersMenu om = new OrdersMenu();
				om.ordersMenu();
				exit = true;
				break;
		case 4:
				System.out.println("Goodbye!");
				System.exit(0);
				exit = false;
		default:
			System.out.println("Invalid option, try again!\n");
			exit = false;
			break;
		}
	
	
	}while(exit!= true);
	}
}
