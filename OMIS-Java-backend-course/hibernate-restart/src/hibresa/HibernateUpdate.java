package hibresa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUpdate {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		
		try {
			
			sessionFactory = new Configuration()
					 .configure("hibernate.cfg.xml")
					 .addAnnotatedClass(Item.class)
					 .buildSessionFactory();

			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			int id = 4;
			Item dbItem = session.get(Item.class, id);
			dbItem.setEndurance((dbItem.getEndurance()+8));
			session.getTransaction().commit();
			
			session.beginTransaction();
			session.createQuery("UPDATE Item i set i.endurance='5' WHERE i.id='2'").executeUpdate();
			dbItem.setEndurance((dbItem.getEndurance()-1));
			
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
