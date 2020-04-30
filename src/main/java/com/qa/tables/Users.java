package com.qa.tables;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.qa.connection.DBcon;
import com.qa.main.Logic;
import com.qa.menus.Factory;
import com.qa.menus.ReturnMenu;
import com.qa.menus.UsersMenu;

public class Users {
	DBcon connection = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	ReturnMenu rm = new ReturnMenu(connection);

	public Users(DBcon connPassed) {
			connection = connPassed;		
			conn = connection.call();
			//stmt = conn.createStatement();
			stmt = connPassed.getStmt();			
		}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createUser(int userID, String userName, String password, String firstName, String lastName) {
		String myStr = "";
		String create = "INSERT INTO " + "users" + " VALUES(" + userID + ",'" + userName + "','" + password + "','"
				+ firstName + "','" + lastName + "')";
		try {
			stmt.executeUpdate(create);
			System.out.println("Record created!");
			myStr = "okay";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			myStr = "failed";
			e.printStackTrace();
		}
		}

	public void readUser() {
		String read = "SELECT userID,userName,password,firstName,lastName from users";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int i1 = rs.getInt("userID");
				String user1 = rs.getString("userName");
				String pass = rs.getString("password");
				String first = rs.getString("firstName");
				String last = rs.getString("lastName");
				System.out.println("User ID: " + i1 + "\nUserName: " + user1 + " Password " + pass + " First Name: " + first
						+ " Last Name: " + last);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //garbage collection 
		stmt = null;
		
	}

	public void updateUserName(int ID, String name) {
		String update = "update users" + " set userName='" + name + "' where userID=" + ID;
		stmt = connection.getStmt();
		try {
			stmt.executeUpdate(update);
			System.out.println("Record updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error!");
			e.printStackTrace();
		}
			
	}
	
	public void updateUserPass(int ID, String password) {
		String update = "update users" + " set password='" + password + "' where userID=" + ID;
		stmt = connection.getStmt();
		try {
			stmt.executeUpdate(update);
			System.out.println("User updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error!");
			e.printStackTrace();
		}
		
		}
	
	public void updateFname(int ID, String firstName) {
		String update = "UPDATE users SET firstName='" + firstName + "' WHERE userID=(" + ID +")";
		stmt = connection.getStmt();
		try {
			stmt.executeUpdate(update);
			System.out.println("User updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error!");
			e.printStackTrace();
		}
		
	}
	
	public void updateLname(int ID, String lastName) {
		String update = "update users" + " set lastName='" + lastName + "' where userID=" + ID;
		stmt = connection.getStmt();
		try {
			stmt.executeUpdate(update);
			System.out.println("User updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error!");
			e.printStackTrace();
		}
		
	}

	public void deleteUser(int ID) {
		String delete = "DELETE FROM " + "users" + " WHERE userID=" + ID;
		stmt = connection.getStmt();
		try {
			stmt.executeUpdate(delete);
			System.out.println("record deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
