package com.qa.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.connection.DBcon;

public class Orders {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public Orders() {
		try {
			conn = new DBcon().call();
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
			System.out.println("order added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
				System.out.println("Order ID: " + i1 + "productID: " + i2 + "userID: " + i3 + "quantity: " + q + "Price" + pr);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateOrder(int ID, int quantity) {
		String update = "update orders" + " set quantity='" + quantity + "' where orderID=" + ID;
		try {
			stmt.executeUpdate(update);
			System.out.println("order updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error!");
			e.printStackTrace();
		}
	}

	public void deleteOrder(int ID) {
		String delete = "DELETE FROM " + "orders" + " WHERE orderID=" + ID;
		try {
			stmt.executeUpdate(delete);
			System.out.println("order deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
