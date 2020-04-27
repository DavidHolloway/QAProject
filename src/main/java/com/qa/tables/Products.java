package com.qa.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.connection.DBcon;
import com.qa.menus.ReturnMenu;

public class Products {
	ReturnMenu rm = new ReturnMenu();
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public Products() {
		try {
			conn = new DBcon().call();
			stmt = conn.createStatement();	
		}catch (SQLException e) {
			System.out.println("Error - Cannot connect to database");
			e.printStackTrace();
		}
	}
	public void createProduct(int productID, String productName, double price, int stock) {
		String create = "INSERT INTO " + "products" + " VALUES(" + productID + ",'" + productName + "'," + price + ","
				+ stock + ")";
		try {
			stmt.executeUpdate(create);
			System.out.println("Product added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rm.returnMenu();
	}

	public void readProduct() {
		String read = "SELECT productID,productName,price,stock from products";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------------------Products---------------------");

		try {
			while (rs.next()) {
				int i1 = rs.getInt("productID");
				String prod = rs.getString("productName");
				Double p = rs.getDouble("price");
				int s = rs.getInt("stock");
				System.out.println("Product ID: " + i1 + "\nProductName: " + prod + " Price: £" + p + " Stock: " + s + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rm.returnMenu();
	}

	public void updateProduct(int ID, String name) {
		String update = "update products" + " set productName='" + name + "' where productID=" + ID;
		try {
			stmt.executeUpdate(update);
			System.out.println("product updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error!");
			e.printStackTrace();
		}
	}

	public void deleteProduct(int ID) {
		String delete = "DELETE FROM " + "products" + " WHERE productID=" + ID;
		try {
			stmt.executeUpdate(delete);
			System.out.println("product deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
