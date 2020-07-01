package ee.omis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameSpringApp {

	public static void main(String[] args) {
		
		// Create connection
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get bean
		Item myItem = context.getBean("item", Item.class);
		Item myItemBoot = context.getBean("itemBoot", Item.class);
		
		// Create methods
		System.out.println("Spring: " +myItem.getItemDescription());
		System.out.println("Spring: " +myItem.getFromDatabase());
		
		System.out.println("SpringBoot: " +myItemBoot.getItemDescription());
		System.out.println("SpringBoot: " +myItemBoot.getFromDatabase());
		
		// Close connection
		context.close();
	}

}
