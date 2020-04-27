package com.qa.menus;

import java.util.Scanner;

import com.qa.main.Logic;
import com.qa.tables.Products;

public class ProductsMenu {
	
int productID = 0;
	
	public void productsMenu() {
		Products p = new Products();
		Scanner sc = new Scanner(System.in);
		//p.connect();

		System.out.println("Please Select an option: Create[1], Read[2], Update[3], Delete[4]");
		int p1 = sc.nextInt();
		System.out.println();
		sc.nextLine();
		switch (p1) {
		case 1:
			System.out.println("Please enter product name:");
			String prod = sc.nextLine();
			System.out.println("\nPlease enter the price:");
			double pr = sc.nextDouble();
			System.out.println();
			sc.nextLine();
			System.out.println("\nPlease enter the amount of stock:");
			int st = sc.nextInt();
			System.out.println();
			sc.nextLine();
			p.createProduct(productID, prod, pr, st);
			break;
		case 2:
			p.readProduct();
			System.out.println("Press enter to return to menu");
			sc.nextLine();
			Logic l = new Logic();
			l.run();
			break;
		case 3:
			System.out.println("Please enter your productID: ");
			int id = sc.nextInt();
			System.out.println();
			sc.nextLine();
			System.out.println("\nPlease enter the new product name: ");
			String name = sc.nextLine();
			p.updateProduct(id, name);
			break;
		case 4:
			System.out.println("Please enter your productID: ");
			int idDel = sc.nextInt();
			p.deleteProduct(idDel);
			break;
		}
	}


}
