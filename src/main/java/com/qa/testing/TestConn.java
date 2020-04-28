package com.qa.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConn {
	public final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost:3306/testinventorymanagmentsys?";
	// "jdbc:mysql://localhost:3306/inventorymanagmentsys?useSSL=false";
	// 34.89.47.160/inventorymanagmentsys?user=root&password=root"
	public final String USER = "root";
	public final String PASS = "root";

	Connection conn = null;
	Statement stmt = null;

	public TestConn() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public Connection call() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected\n");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

