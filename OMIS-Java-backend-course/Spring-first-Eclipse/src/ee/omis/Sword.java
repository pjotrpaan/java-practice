package ee.omis;

public class Sword implements Item {
	
	private ItemDatabaseService databaseService;
	
	public Sword() {}
	
	public Sword(ItemDatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
	}
	
	public String getItemDescription() {
		return "Item is SWORD";
	}
	
	public String getFromDatabase() {
		return databaseService.getItemFromDatabase();
	}
}
