package com.qa.menus;

import java.util.Scanner;

import com.qa.connection.DBcon;
import com.qa.main.Logic;
import com.qa.tables.Products;

public class ProductsMenu {

	int productID = 0;
	DBcon connection = null;
	
	public ProductsMenu(DBcon connPassed) {
		connection = connPassed;		
	}
		
	public void productMenu() {
		Products p = new Products(connection);
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		do {
		System.out.println(
				"Please Select An Option:\n1 - Create a new product\n2 - Display existing items\n3 - Update a product\n4 - Delete a product\n5 - Return");
		int p1 = sc.nextInt();
		System.out.println();
		sc.nextLine();
		switch (p1) {
		case 1:
			System.out.println("Please enter the product name: ");
			String prod = sc.nextLine();
			System.out.println("\nPlease enter the price: ");
			double pr = sc.nextDouble();
			System.out.println();
			sc.nextLine();
			System.out.println("\nPlease enter the amount of stock: ");
			int st = sc.nextInt();
			System.out.println();
			sc.nextLine();
			p.createProduct(productID, prod, pr, st);
			break;
		case 2:
			p.readProduct();
			break;
		case 3:
			System.out.println(
					"Please select what you would like to update:\n1 - Product Name\n2 - Price of the product\n3 - Number of product in stock");
			int up = sc.nextInt();
			System.out.println();
			sc.nextLine();
			switch (up) {
			case 1:
				System.out.println("Please enter the ID of the product you would like to update: ");
				int id = sc.nextInt();
				System.out.println();
				sc.nextLine();
				System.out.println("Please enter the new product name: ");
				String name = sc.nextLine();
				p.updateProductName(id, name);
				break;
			case 2:
				System.out.println("Please enter the ID of the product you would like to update: ");
				int id2 = sc.nextInt();
				System.out.println();
				sc.nextLine();
				System.out.println("Please enter the new product price: ");
				double np = sc.nextDouble();
				p.updateProductPrice(id2, np);
				break;
			case 3:
				System.out.println("Please enter the ID of the product you would like to update: ");
				int id3 = sc.nextInt();
				System.out.println();
				sc.nextLine();
				System.out.println("Please enter the new stock level of the product: ");
				double ns = sc.nextDouble();
				p.updateProductPrice(id3, ns);
				break;
			default:
				System.out.println("Please enter a valid number");
				break;
			}
			break;
		case 4:
			System.out.println("Please enter the productID of the item you wish to delete: ");
			int idDel = sc.nextInt();
			p.deleteProduct(idDel);
			break;
		case 5:
			Logic l =Factory.getLogic(connection);
			l.run();
			break;
		default:
			System.out.println("Please enter a valid number!");
			exit = true;
			break;
		}
		}while(exit == true);
	}

}
