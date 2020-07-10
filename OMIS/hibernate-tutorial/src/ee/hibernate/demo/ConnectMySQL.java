package ee.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectMySQL {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student tempStudent = new Student("paul.temp@temppaul.com", "Paul", "Temp");
			
			session.beginTransaction();
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Temp student saved to db!");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			factory.close();
		}
		
	}

}
