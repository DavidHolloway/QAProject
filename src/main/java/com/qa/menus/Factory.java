package com.qa.menus;

import java.util.Scanner;

import com.qa.connection.DBcon;
import com.qa.main.Logic;

public class Factory {
	
	
	private static Logic l;
	private static UsersMenu um;
	private static ProductsMenu pm;
	private static OrdersMenu om;



	public static Logic getLogic(DBcon connection) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press enter to return to menu...");
		sc.nextLine();		
		if(l==null) {
			l = new Logic(connection);
			return l;
		}else {
			return l;
		}
	}
	
	public static UsersMenu getUserMenu(DBcon connection) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPress enter to return to menu...");
		sc.nextLine();		
		if(um==null) {
			um = new UsersMenu(connection);
			return um;
		}else {
			return um;
		}
	}
	

	public static ProductsMenu getProductsMenu(DBcon connection) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPress enter to return to menu...");
		sc.nextLine();		
		if(pm==null) {
			pm = new ProductsMenu(connection);
			return pm;
		}else {
			return pm;
		}
	}
	

	public static OrdersMenu getOrdersMenu(DBcon connection) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPress enter to return to menu...");
		sc.nextLine();		
		if(om==null) {
			om = new OrdersMenu(connection);
			return om;
		}else {
			return om;
		}
	}
	

}
