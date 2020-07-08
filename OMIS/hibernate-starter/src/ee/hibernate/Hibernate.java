package ee.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class Hibernate {

	public static void main(String[] args) {
		// Test Jdbc connection to MySQL db on localhost
		String jdbcUrl = "jdbc:mysql://localhost:3306/vendure?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pw = "root";
		
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
