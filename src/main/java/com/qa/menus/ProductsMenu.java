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

		System.out.println("Please Select An Option:\n1 - Create a new product\n2 - Display existing items\n3 - Update a product\n4 - Delete a product");
		int p1 = sc.nextInt();
		System.out.println();
		sc.nextLine();
		switch (p1) {
		case 1:
			System.out.println("Please enter the product name:");
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
			System.out.println("Please enter the productID of the item you wish to delete: ");
			int idDel = sc.nextInt();
			p.deleteProduct(idDel);
			break;
		}
	}


}
