package hibresa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateRead {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		
		try {
			
			sessionFactory = new Configuration()
					 .configure("hibernate.cfg.xml")
					 .addAnnotatedClass(Item.class)
					 .buildSessionFactory();

			Session session = sessionFactory.openSession();
		
			session.beginTransaction();
			Item item = new Item("Boot", 3, Level.STANDARD, 2, true);
			System.out.println(item);
			session.save(item);
			session.getTransaction().commit();
			
			
			session.beginTransaction();
			Item dbItem = session.get(Item.class, item.getId());
			session.getTransaction().commit();
			System.out.println(dbItem);
					
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}
	}

}
