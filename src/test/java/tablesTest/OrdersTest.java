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
import com.qa.tables.Orders;
import com.qa.tables.Products;
import com.qa.tables.Users;

@RunWith(MockitoJUnitRunner.class)
public class OrdersTest {
	
	static Connection conn = null;
    static Statement stmtTest;
	ResultSet rs = null;
	DBcon dbCon;
	
	static Orders o;
	static Products p;
	static Users u;


	
	@BeforeClass
	public static void startConnect() {
		DBcon dbCon = new DBcon("testinventorymanagmentsys");
		o = new Orders(dbCon);	
		conn = dbCon.call();
		stmtTest = dbCon.getStmtTest();
	}
	
	@Before
	public void init() {
		//u.createUser(1, "userName1", "password1", "firstName1", "lastName1");
		//p.createProduct(1, "productName1", 19.99, 5);
		
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
		String insert2 = ("INSERT INTO " + "products" + "(productID, productName, price, stock)" 
		+ " VALUES (1, \"product1\", 19.99,5);");
		try {
			stmtTest.executeUpdate(insert2);
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void createOrder() {
	
				
				//INSERT INTO users (userID, userName, password, firstName, lastName) VALUES (1, "user1", "password","user","test");
		o.createOrder(1, 1, 1, 5, 19.99);

		String readall = "SELECT * FROM orders WHERE orderID=1";
        try {
            rs = stmtTest.executeQuery(readall);
            while (rs.next()) {
                int st  = rs.getInt("quantity");
                assertEquals(5, st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
	}	
	
	@Test
	public void readOrder() {
		o.readOrder();
		String read = "SELECT * from orders where orderID= 1";
		 try {
	            rs = stmtTest.executeQuery(read);
	            while (rs.next()) {
	                int on = rs.getInt("orderID");
	                int pi = rs.getInt("productID");
					int ui = rs.getInt("userID");
					int q = rs.getInt("quantity");
					double p = rs.getDouble("price");
	                assertEquals(1, on);
	                assertEquals(1, pi);
	                assertEquals(1, ui);
	                assertEquals(5, q);
	                assertEquals(19.99, p,0.1);

	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            fail();
	        }
	}
	
	@Test
	public void deleteOrder() {
		String delete = "DELETE FROM " + "orders" + " WHERE orderID=" + 1;
		try {
			stmtTest.executeUpdate(delete);
			System.out.println("Order Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@After
	public void removeCreate() {
		
		String deleteAll = "DELETE FROM orders where orderID=1";
		System.out.println(deleteAll);
		try {
			stmtTest.executeUpdate(deleteAll);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String deleteAll1 = "DELETE FROM users where userID=1";
		try {
			stmtTest.executeUpdate(deleteAll1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String deleteAll2 = "DELETE FROM products where productID=1";
		try {
			stmtTest.executeUpdate(deleteAll2);
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
		//conn = null;
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

