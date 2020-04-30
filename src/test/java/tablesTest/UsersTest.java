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
		u.createUser(5, "user5", "12345", "firstName5", "lastName5");
		
	}
	
	@Test
	public void createTest() {

		String readall = "SELECT * FROM users WHERE firstName='firstName5'";
        try {
            rs = stmtTest.executeQuery(readall);
            while (rs.next()) {
                String un = rs.getString("userName");
                assertEquals("user5", un);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
	}	
	
	@Test
	public void readUser() {
		u.readUser();
		String read = "SELECT userID,userName,password,firstName,lastName from users";
		 try {
	            rs = stmtTest.executeQuery(read);
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
	
//	@Test
//	public void updateUser() {
//		u.updateFname(5, "newfirstName5");
//		String read = "SELECT userID,firstName from users";
//		try {
//            rs = stmtTest.executeQuery(read);
//            while (rs.next()) {
//                //String un = rs.getString("userName");
//                //String pass = rs.getString("password");
//				String first = rs.getString("firstName");
//				//String last = rs.getString("lastName");
//               // assertEquals("user5", un);
//               // assertEquals("12345", pass);
//                assertEquals("newfirstName5", first);
//                //assertEquals("lastName5", last);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            fail();
//        }
//		
//		
//	}
	
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
		conn = null;
	}
	

}
