package tablesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.connection.DBcon;
import com.qa.menus.UsersMenu;
import com.qa.tables.Users;

@RunWith(MockitoJUnitRunner.class)
public class UsersTest {
	
	static Connection conn = null;
	static Statement stmt = null;
	ResultSet rs = null;
//	 @Spy @InjectMocks
//	Users u = mock(Users.class);
	//DBcon db = new DBcon("testinventorymanagmentsys");
	
	static Users u;
	//Users u = new Users(db);
	
	@BeforeClass
	public static void startConnect() {
		DBcon dbCon = new DBcon("testinventorymanagmentsys");
		u = new Users(dbCon);	
		conn = dbCon.call();
		stmt = dbCon.getStmt();
		System.out.println("this is user test class");
	}
	
	@Before
	public void populate() {
		u.createUser(5, "user5", "12345", "firstName5", "lastName5");
	}
	
	@Test
	public void createTest() {
//		u.createUser(6, userName, password, firstName, lastName);
//		select
//		verify assert equal
	//	verify(u, never())

//		assertEquals(u.createUser(6, "user6", "123456", "firstName6", "lastName6"),"okay"); 
//		assertEquals(u.createUser(7, "user7", "1234567", "firstName7", "lastName7"),"okay");
//		assertEquals(u.createUser(6, "user6", "123456", "firstName6", "lastName6"),"failed"); 

		//u.createUser(0, "user1", "12345", "firstName1", "lastName1");
		u.createUser(0, "user1", "12345", "firstName1", "lastName1");

		String readall = "SELECT * FROM users WHERE firstName='firstName1'";
        try {
            rs = stmt.executeQuery(readall);
            while (rs.next()) {
                String un = rs.getString("userName");
                assertEquals("user1", un);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
	}
		//String tUser2 = u.createUser(0, "user2", "12345", "firstName2", "lastName2");
		//String tUser3 = u.createUser(0, "user2", "12345", "firstName2", "lastName2");

		//assertEquals(tUser1,"okay");
		//assertEquals(tUser2,"okay");
		//assertEquals(tUser3,"failed");


//		Customer customer = new Customer(firstName, surname);		 
//		Customer savedCustomer = new Customer(1L,"Chris", "Perrins");		 
//		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);		 
//		assertEquals(savedCustomer, customerController.create());
	
	
	@Test
	public void readUser() {
		//u.createUser(0, "user2", "12345", "firstName2", "lastName2");
		u.readUser();
		String read = "SELECT userID,userName,password,firstName,lastName from users";
		 try {
	            rs = stmt.executeQuery(read);
	            while (rs.next()) {
	                String un = rs.getString("userName");
	                String pass = rs.getString("password");
					String first = rs.getString("firstName");
					String last = rs.getString("lastName");
	                assertEquals("user5", un);
	                assertEquals("12345", pass);
	                assertEquals("firstName5", first);
	                assertEquals("lastName5", last);

	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            fail();
	        }
	}
	
	@Test
	public void updateUser() {
		u.updateFname(5, "newfirstName5");
		String read = "SELECT userID,firstName from users";
		try {
            rs = stmt.executeQuery(read);
            while (rs.next()) {
                //String un = rs.getString("userName");
                //String pass = rs.getString("password");
				String first = rs.getString("firstName");
				//String last = rs.getString("lastName");
               // assertEquals("user5", un);
               // assertEquals("12345", pass);
                assertEquals("newfirstName5", first);
                //assertEquals("lastName5", last);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
		
		
	}
	
	@After
	public void removeCreate() {
//		statement to delete everything
		String deleteAll = "DELETE FROM users";
		try {
			stmt.executeUpdate(deleteAll);
		}catch (SQLException e) {
			e.printStackTrace();
		}
//		ALTER TABLE users ALTER COLUMN auto_increment_userID RESTART WITH 0
		
	}
	
	@AfterClass
	public static void endConnection() {
		conn = null;
	}
	

}
