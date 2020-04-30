package tablesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
	
	static Connection conn;
    static Statement stmtTest;
	ResultSet rs = null;
	DBcon dbCon;
	static Users u;
	
	@BeforeClass
	public static void startConnect() {
		DBcon dbCon = new DBcon("testinventorymanagmentsys");
		u = new Users(dbCon);	
		conn = dbCon.call();
		stmtTest = dbCon.getStmtTest();
	}
	
	@Before
	public void init() {
		String insert1 = ("INSERT INTO " + "users" + "(userID, userName, password,"
				+ " firstName, lastName)" + "VALUES (1, \"userName1\", \"password1\", "
						+ "\"firstName1\", \"lastName1\");");
		try {
			stmtTest.executeUpdate(insert1);
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	@Test
	public void createTest() {
		
		//u.createUser(5, "user5", "12345", "firstName5", "lastName5");

		String readall = "SELECT * FROM users WHERE userID=1";
        try {
            rs = stmtTest.executeQuery(readall);
            while (rs.next()) {
                String un = rs.getString("userName");
                assertEquals("userName1", un);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        
        }
        
	}	
	
	@Test
	public void readUser() {
		u.readUser();
		String read = "SELECT * from users where userID= 1";
		 try {
	            rs = stmtTest.executeQuery(read);
	            while (rs.next()) {
	                String un = rs.getString("userName");
	                String pass = rs.getString("password");
					String first = rs.getString("firstName");
					String last = rs.getString("lastName");
	                assertEquals("userName1", un);
	                assertEquals("password1", pass);
	                assertEquals("firstName1", first);
	                assertEquals("lastName1", last);

	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            fail();
	        }
	}
	
	@Test
	public void updateUser() {
		u.updateFname(1, "newfirstName5");
		String read = "SELECT userID,firstName from users where userID= 1";
		try {
            rs = stmtTest.executeQuery(read);
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
	
	@Test
	public void updateLastName() {
		u.updateLname(1, "newLastName");
		String read = "SELECT userID,lastName from users where userID= 1";
		try {
            rs = stmtTest.executeQuery(read);
            while (rs.next()) {
				String ln = rs.getString("lastName");
                assertEquals("newLastName", ln);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
		
		
	}
	
	@Test
	public void updateUserName() {
		u.updateUserName(1, "userName5");
		String read = "SELECT userID,userName from users where userID= 1";
		try {
            rs = stmtTest.executeQuery(read);
            while (rs.next()) {
				String first = rs.getString("userName");
                assertEquals("userName5", first);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
		
		
	}
	@Test
	public void updatePass() {
		u.updateUserPass(1, "newPass");
		String read = "SELECT userID,password from users where userID= 1";
		try {
            rs = stmtTest.executeQuery(read);
            while (rs.next()) {
				String p = rs.getString("password");
                assertEquals("newPass", p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
		
		
	}
	
	@Test
	public void deleteCust() {
		String delete = "DELETE FROM " + "users" + " WHERE userID=" + 5;
		try {
			stmtTest.executeUpdate(delete);
			System.out.println("User Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	@After
	public void removeCreate() {
		
		String deleteAll = "DELETE FROM users";
		//where userName='user5'
		System.out.println(deleteAll);
		try {
			stmtTest.executeUpdate(deleteAll);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

////		statement to delete everything
//		String deleteAll = "TRUNCATE TABLE users;";
//		stmt.executeUpdate(deleteAll);
////		ALTER TABLE users ALTER COLUMN auto_increment_userID RESTART WITH 0
//		
	}
	
	@AfterClass
	public static void endConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
