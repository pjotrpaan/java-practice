package ee.omis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameSpringScopeApp {

	public static void main(String[] args) {
		// Create connection
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("scope-applicationContext.xml");
		
		// Get bean
		Item myItem1 = context.getBean("item1", Item.class);
		Item myItem2 = context.getBean("item2", Item.class);
		Item myItem3 = context.getBean("item3", Item.class);
		Item myItem3Copy = context.getBean("item3", Item.class);
		Item myItem4 = context.getBean("item4", Item.class);
		Item myItem4Copy = context.getBean("item4", Item.class);
		Item myItem5 = context.getBean("item5", Item.class);
		Item myItem6 = context.getBean("item6", Item.class);
		
		
		// Create methods
		if (myItem1 == myItem2) {
			System.out.println("myItem1 and myItem2 ARE equal");
		} else {
			System.out.println("myItem1 and myItem2 ARE NOT equal");
		}
		
		if (myItem3 == myItem3Copy) {
			System.out.println("Singleton: myItem3 and myItem3Copy ARE equal");
		} else {
			System.out.println("Singleton: myItem3 and myItem3Copy ARE NOT equal");
		}
		
		if (myItem4 == myItem4Copy) {
			System.out.println("Prototype: myItem4 and myItem4Copy ARE equal");
		} else {
			System.out.println("Prototype: myItem4 and myItem4Copy ARE NOT equal");
		}
		
		// Close connection
		context.close();
				

	}

}
