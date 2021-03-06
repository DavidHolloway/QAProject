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
import com.qa.tables.Products;
import com.qa.tables.Users;

@RunWith(MockitoJUnitRunner.class)
public class ProductsTest {
	
	static Connection conn = null;
    static Statement stmtTest;
	ResultSet rs = null;
	DBcon dbCon;
	
	static Products p;
	
	@BeforeClass
	public static void startConnect() {
		DBcon dbCon = new DBcon("testinventorymanagmentsys");
		p = new Products(dbCon);	
		conn = dbCon.call();
		stmtTest = dbCon.getStmtTest();
	}
	
	@Before
	public void init() {
		//p.createProduct(1,"iphone", 199.99, 20);
		p.createProduct(2,"iphone", 199.99, 20);
	}
	
	@Test
	public void createProduct() {

		String readall = "SELECT * FROM products WHERE productName='iphone'";
        try {
            rs = stmtTest.executeQuery(readall);
            while (rs.next()) {
                String pn = rs.getString("productName");
                assertEquals("iphone", pn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
	}	
	
	@Test
	public void readProduct() {
		p.readProduct();
		String read = "SELECT productID,productName,price,stock from products where productID= 2";
		 try {
	            rs = stmtTest.executeQuery(read);
	            while (rs.next()) {
	                String pn = rs.getString("productName");
	                double pc = rs.getDouble("price");
					int st = rs.getInt("stock");
	                assertEquals("iphone", pn);
	                assertEquals(199.99, pc, 0.1);
	                assertEquals(20, st);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            fail();
	        }
	}
	
	@Test
	public void updateProductName() {
		p.updateProductName(2,"newProductName");
		String read = "SELECT productID,productName from products where productID= 2";
		try {
            rs = stmtTest.executeQuery(read);
            while (rs.next()) {
				String pn = rs.getString("productName");
                assertEquals("newProductName", pn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
	}
	
	@Test
	public void updateProductPrice() {
		p.updateProductPrice(2,10.99);
		String read = "SELECT productID,price from products where productID= 2";
		try {
            rs = stmtTest.executeQuery(read);
            while (rs.next()) {
				double pc = rs.getDouble("price");
                assertEquals(10.99, pc,0.1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
	}
	
	@Test
	public void updateProductStock() {
		p.updateProductStock(2,15);
		String read = "SELECT productID,stock from products where productID= 2";
		try {
            rs = stmtTest.executeQuery(read);
            while (rs.next()) {
				int st = rs.getInt("stock");
                assertEquals(15, st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
	}
	
	
	
	@Test
	public void deleteProduct() {
		String delete = "DELETE FROM " + "products" + " WHERE productID= 2";
		try {
			stmtTest.executeUpdate(delete);
			System.out.println("Product Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}	
	@After
	public void removeCreate() {
		
		String deleteAll = "DELETE FROM products";
		System.out.println(deleteAll);
		try {
			stmtTest.executeUpdate(deleteAll);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
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

