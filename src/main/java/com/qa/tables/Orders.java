package com.qa.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.qa.connection.DBcon;
import com.qa.menus.Factory;
import com.qa.menus.OrdersMenu;
import com.qa.menus.ReturnMenu;
import com.qa.menus.UsersMenu;

public class Orders {
	DBcon connection = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Orders(DBcon connPassed) {
		connection = connPassed;
		try {
			conn = connection.call();
			stmt = conn.createStatement();	
		}catch (SQLException e) {
			System.out.println("Error - Cannot connect to database");
			e.printStackTrace();
		}
	}
	public void createOrder(int orderID, int productID, int userID, int quantity, double price) {
		String create = "INSERT INTO " + "orders" + " VALUES(" + orderID + "," + productID + "," + userID + "," + quantity +
				"," + price + ")";
		try {
			stmt.executeUpdate(create);
			System.out.println("Order Added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrdersMenu om =Factory.getOrdersMenu(connection);
		om.orderMenu();
	}

	public void readOrder() {
		String read = "SELECT orderID,productID,userID,quantity,price from orders";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int i1 = rs.getInt("orderID");
				int i2 = rs.getInt("productID");
				int i3 = rs.getInt("userID");
				int q = rs.getInt("quantity");
				Double pr = rs.getDouble("price");
				System.out.println("Order ID: " + i1 + "\nProductID: " + i2 + " UserID: " + i3 + " Quantity: " + q + " Price" + pr);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrdersMenu om =Factory.getOrdersMenu(connection);
		om.orderMenu();
	}
	
//	public double readPrice(int productID, int quantity) {
//		double value;
//		double sum;
//		String read = "SELECT price from products where productID=" + productID;
//		value = Double.parseDouble(read);
//		sum = (value*quantity);
//		return sum;
//	
//	}
	
	// use sql sum 
	//function add item to order 
	//take item ID get price

	public void updateOrder(int ID, int quantity) {
		String update = "update orders" + " set quantity='" + quantity + "' where orderID=" + ID;
		try {
			stmt.executeUpdate(update);
			System.out.println("Order Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error!");
			e.printStackTrace();
		}
		OrdersMenu om =Factory.getOrdersMenu(connection);
		om.orderMenu();
	}

	public void deleteOrder(int ID) {
		String delete = "DELETE FROM " + "orders" + " WHERE orderID=" + ID;
		try {
			stmt.executeUpdate(delete);
			System.out.println("Order deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrdersMenu om =Factory.getOrdersMenu(connection);
		om.orderMenu();
	}

}
