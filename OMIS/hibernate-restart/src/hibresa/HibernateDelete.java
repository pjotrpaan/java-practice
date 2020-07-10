package hibresa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDelete {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		
		try {
			
			sessionFactory = new Configuration()
					 .configure("hibernate.cfg.xml")
					 .addAnnotatedClass(Item.class)
					 .buildSessionFactory();

			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			int id = 7;
			Item dbItem = session.get(Item.class, id);
			session.delete(dbItem);
			session.getTransaction().commit();
			
					
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}

	}

}
