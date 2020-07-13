package hibresa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateQuery {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		
		try {
			
			sessionFactory = new Configuration()
					 .configure("hibernate.cfg.xml")
					 .addAnnotatedClass(Item.class)
					 .buildSessionFactory();

			Session session = sessionFactory.openSession();
			
			session.beginTransaction();

			List<Item> itemsList = session.createQuery("FROM Item").getResultList();
			
			for(Item item : itemsList) {
				System.out.println(item);
			}
			
			List<Item> swordsList = session.createQuery("FROM Item i WHERE i.name='Sword'").getResultList();
			
			for(Item sword : swordsList) {
				System.out.println(sword);
			}
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
