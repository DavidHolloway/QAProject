package com.qa.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcon {

	public final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public String DB_URL;
	// "jdbc:mysql://localhost:3306/inventorymanagmentsys?useSSL=false";
	// 34.89.47.160/inventorymanagmentsys?user=root&password=root"
	public final String USER = "root";
	public final String PASS = "root";

	Connection conn = null;
//	public Connection connect() {
//		try {
//			Class.forName(JDBC_DRIVER);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Starting connection to database");
//		try {
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			// System.out.println("connected!!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
	//inventorymanagmentsys
	public DBcon(String database) {
		DB_URL = "jdbc:mysql://localhost:3306/"+database+"?useSSL=false";
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
	
	public Statement getStmt() {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
}
