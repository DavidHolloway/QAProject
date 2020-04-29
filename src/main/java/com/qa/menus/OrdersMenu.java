package com.qa.menus;

import java.util.Scanner;

import com.qa.connection.DBcon;
import com.qa.main.Logic;
import com.qa.tables.Orders;

public class OrdersMenu {
	int orderID = 0;
	int userID = 0;
	DBcon connection = null;
	
	public OrdersMenu(DBcon connPassed) {
		connection = connPassed;		
	}

	public void orderMenu() {
		Orders o = new Orders(connection);
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("Please Select an option:\n1 - Create a new order\n2 - View existing orders\n3 - Update an order\n4 - Delete an order\n5 - Return");
		int o1 = sc.nextInt();
		System.out.println();
		sc.nextLine();
		switch (o1) {
		case 1:
			System.out.println("Please enter product ID which exists:");
			int pID = sc.nextInt();
			System.out.println("Please enter user ID:");
			int uID = sc.nextInt();
			System.out.println("Please enter quantity:");
			int quant = sc.nextInt();
			System.out.println("\nPlease enter total price:");
			double price = sc.nextDouble();
			System.out.println();
			//double price = o.readPrice(pID,quant);
			//System.out.println(price);
			//take input and pass from here
			//sc.nextLine();
			o.createOrder(orderID, pID, uID, quant, price);
			break;
		case 2:
			o.readOrder();	
			break;
		case 3:
			System.out.println("Please enter your orderID: ");
			int id = sc.nextInt();
			System.out.println();
			sc.nextLine();
			System.out.println("\nPlease enter the new order quantity: ");
			int quant2 = sc.nextInt();
			o.updateOrder(id, quant2);
			break;
		case 4:
			System.out.println("Please enter your orderID to delete: ");
			int idDel = sc.nextInt();
			o.deleteOrder(idDel);
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
		}while(exit==true);
	}

}

