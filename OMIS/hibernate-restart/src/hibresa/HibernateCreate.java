package hibresa;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCreate {

	public static void main(String[] args) {
		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/game?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pw = "rootpass";
		
		try {
			System.out.println("Connecting to db: " + jdbcUrl);
			Connection mySqlConn = DriverManager.getConnection(jdbcUrl, user, pw);
			mySqlConn.close();
			System.out.println("Db is live. Starting session...");
			
			SessionFactory factory = new Configuration()
					 .configure("hibernate.cfg.xml")
					 .addAnnotatedClass(Item.class)
					 .buildSessionFactory();

			Session session = factory.openSession();
			
			try {
			
			session.beginTransaction();
			
			Item item = new Item("Boot", 3, Level.STANDARD, 2, true);
			session.save(item);
			
			session.getTransaction().commit();
			
			System.out.println("Item saved to db!");
			
			}
			catch(Exception exc) {
			exc.printStackTrace();
			}
			finally {
			factory.close();
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
