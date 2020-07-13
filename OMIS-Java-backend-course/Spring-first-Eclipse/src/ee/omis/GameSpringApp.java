package ee.omis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameSpringApp {

	public static void main(String[] args) {
		
		// Create connection
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get bean
		Item myItem = context.getBean("item", Item.class);
		Boot myItemBoot = context.getBean("itemBoot", Boot.class);
		
		// Create methods
		System.out.println("Spring: " +myItem.getItemDescription());
		System.out.println("Spring: " +myItem.getFromDatabase());
		
		System.out.println("SpringBoot: " +myItemBoot.getItemDescription());
		System.out.println("SpringBoot: " +myItemBoot.getFromDatabase());
		System.out.println("SpringBoot: " +myItemBoot.getEndurance());
		System.out.println("SpringBoot: " +myItemBoot.getLevel());
//		System.out.println("SpringBoot: " +myItemBoot.setEndurance());
		System.out.println("SpringBoot: " +myItemBoot.setLevel("GOLD"));
		
		// Close connection
		context.close();
	}

}
