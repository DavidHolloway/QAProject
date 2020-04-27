package com.qa.menus;

import java.util.Scanner;

import com.qa.tables.Orders;

public class OrdersMenu {
	int orderID = 0;
	int userID = 0;


	public void ordersMenu() {
		Orders o = new Orders();
		Scanner sc = new Scanner(System.in);

		//o.connect();
		System.out.println("Please Select an option: Create[1], Read[2], Update[3], Delete[4]");
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
			sc.nextLine();
			o.createOrder(orderID, pID, uID, quant, price);
			break;
		case 2:
			o.readOrder();
//			System.out.println("Press enter to return to menu");
//			sc.nextLine();
			
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
		}
	}

}

