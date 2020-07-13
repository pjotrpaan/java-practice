package ee.omis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameSpringAnnotationsApp {

	public static void main(String[] args) {

		// Create connection
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get bean
		Item sword = context.getBean("swordItem", Item.class);
		Item bootItem = context.getBean("bootItem", Item.class);
		
		// Create methods
		System.out.println(sword.getItemDescription());
		System.out.println(sword.toString());
		System.out.println(bootItem.getItemDescription());

		// Close connection
		context.close();

	}

}
