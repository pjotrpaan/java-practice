package ee.omis;

import org.springframework.stereotype.Component;

@Component("swordItem")
public class Sword implements Item {

	@Override
	public String getItemDescription() {
		// TODO Auto-generated method stub
		return "The sword is mighty!";
	}
	
	
}
