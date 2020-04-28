package com.qa.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.connection.DBcon;
import com.qa.menus.Factory;
import com.qa.menus.ProductsMenu;
import com.qa.menus.ReturnMenu;
import com.qa.menus.UsersMenu;

public class Products {
	DBcon connection = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	//ReturnMenu rm = new ReturnMenu(connection);

	public Products(DBcon connPassed) {
		connection = connPassed;
		try {
			conn = connection.call();
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
		ProductsMenu pm =Factory.getProductsMenu(connection);
		pm.productMenu();
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
		ProductsMenu pm =Factory.getProductsMenu(connection);
		pm.productMenu();
	}

	public void updateProductName(int ID, String name) {
		String update = "update products" + " set productName='" + name + "' where productID=" + ID;
		try {
			stmt.executeUpdate(update);
			System.out.println("product updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error!");
			e.printStackTrace();
		}
		ProductsMenu pm =Factory.getProductsMenu(connection);
		pm.productMenu();
	}
	public void updateProductPrice(int ID, double price) {
		String update = "update products" + " set price='" + price + "' where productID=" + ID;
		try {
			stmt.executeUpdate(update);
			System.out.println("Product Updated");
		} catch (SQLException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
		ProductsMenu pm =Factory.getProductsMenu(connection);
		pm.productMenu();
	}
	
	public void updateProductStock(int ID, int stock) {
		String update = "update products" + " set stock='" + stock + "' where productID=" + ID;
		try {
			stmt.executeUpdate(update);
			System.out.println("Product Updated");
		} catch (SQLException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
		ProductsMenu pm =Factory.getProductsMenu(connection);
		pm.productMenu();
	}

	public void deleteProduct(int ID) {
		String delete = "DELETE FROM " + "products" + " WHERE productID=" + ID;
		try {
			stmt.executeUpdate(delete);
			System.out.println("Product Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProductsMenu pm =Factory.getProductsMenu(connection);
		pm.productMenu();
	}


}
