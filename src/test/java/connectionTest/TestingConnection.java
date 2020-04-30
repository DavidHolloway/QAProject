package connectionTest;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.connection.DBcon;
import com.qa.tables.Users;

@RunWith(MockitoJUnitRunner.class)
public class TestingConnection {
    static Connection connection;
	static DBcon db = new DBcon("testinventorymanagmentsys");
	Users u = new Users(db);
	Statement stmt = null;

	@BeforeClass
	public static void testConn() {
        connection = db.call();		
	}
	@Test
	public void checkDB() {
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DBcon.closeStmt(stmt);;
        try {
			assertTrue(stmt.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void closeConn() {
		connection = null;
	}

}
