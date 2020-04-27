package com.qa.tables;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.qa.connection.DBcon;
import com.qa.main.Logic;
import com.qa.menus.ReturnMenu;

public class Users {
	ReturnMenu rm = new ReturnMenu();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public Users() {
		try {
			conn = new DBcon().call();
			stmt = conn.createStatement();	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void createUser(int userID, String userName, String password, String firstName, String lastName) {
		String create = "INSERT INTO " + "users" + " VALUES(" + userID + ",'" + userName + "','" + password + "','"
				+ firstName + "','" + lastName + "')";
		try {
			stmt.executeUpdate(create);
			System.out.println("Record created!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rm.returnMenu();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Press enter to return to menu");
//		sc.nextLine();
//		Logic l = new Logic();
//		l.run();
		
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
				System.out.println("User ID: " + i1 + "userName: " + user1 + "Password" + pass + "First Name: " + first
						+ "Last Name: " + last);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rm.returnMenu();
	
	}

	public void updateUser(int ID, String name) {
		String update = "update users" + " set userName='" + name + "' where userID=" + ID;
		try {
			stmt.executeUpdate(update);
			System.out.println("Record updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error!");
			e.printStackTrace();
		}
	}

	public void deleteUser(int ID) {
		String delete = "DELETE FROM " + "users" + " WHERE userID=" + ID;
		try {
			stmt.executeUpdate(delete);
			System.out.println("record deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
