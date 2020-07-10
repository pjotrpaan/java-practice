package ee.omis;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		// Test Jdbc connection to MySQL db on localhost
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernatetutorial?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pw = "rootpass";
		
		try {
			System.out.println("Connecting to db: " + jdbcUrl);
			Connection mySqlConn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("Connected to db.");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
