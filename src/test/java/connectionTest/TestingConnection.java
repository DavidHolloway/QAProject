package connectionTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.connection.DBcon;
import com.qa.tables.Users;
import com.qa.testing.TestConn;

@RunWith(MockitoJUnitRunner.class)
public class TestingConnection {
	
	DBcon db = new DBcon("testinventorymanagmentsys");
	Users u = new Users(db);
	@BeforeClass
	public void testConn() {
		db.call();
		u.createUser(1, "TestUser", "password", "firstName", "lastName");
		
	}
	@Test
	public void checkDB() {
		u.readUser();
	}

}
