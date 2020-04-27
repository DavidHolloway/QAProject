package com.qa.menus;

import java.util.Scanner;

import com.qa.main.Logic;

public class ReturnMenu {
	
	public void returnMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press enter to return to menu");
		sc.nextLine();
		Logic l = new Logic();
		l.run();
	}

}
