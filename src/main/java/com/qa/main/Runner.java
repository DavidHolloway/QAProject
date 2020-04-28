package com.qa.main;

import com.qa.connection.DBcon;
import com.qa.main.Logic;

public class Runner {
	
	public static void main(String[] args) {
		DBcon connect = new DBcon("inventorymanagmentsys");
		Logic l = new Logic(connect);
		l.run();
	}


}
