package ee.omis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("swordItem")
public class Sword implements Item {
	
//	@Autowired
//	private String level;
//	@Autowired
//	private int endurance;
//	
//	@Autowired
//	public Sword(String level, int endurance) {
//		this.level = level;
//		this.endurance = endurance;
//	}

	private ItemFromDb itemFromDb;
	
	@Autowired
	public Sword(ItemFromDb _itemFromDb) {
		this.itemFromDb = _itemFromDb;
	}

//	public String getLevel() {
//		return level;
//	}
//
//
//
//	public void setLevel(String level) {
//		this.level = level;
//	}
//
//
//
//	public int getEndurance() {
//		return endurance;
//	}
//
//
//
//	public void setEndurance(int endurance) {
//		this.endurance = endurance;
//	}



	@Override
	public String getItemDescription() {
		// TODO Auto-generated method stub
		return "The sword is mighty!";
	}

	@Override
	public String toString() {
		return String.format(
				"Sword [itemFromDb=%s, getItemDescription()=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				itemFromDb, getItemDescription(), getClass(), hashCode(), super.toString());
	}
	
	
}
