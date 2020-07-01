package ee.omis;

public class Hammer implements Item {
	private ItemDatabaseService databaseService;
	
	public Hammer() {}
	
	public Hammer(ItemDatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
	}
	
	public String getItemDescription() {
		return "Item is HAMMER";
	}
	
	public String getFromDatabase() {
		return databaseService.getItemFromDatabase();
	}
	
	public void thisIsInitMethod() {
		System.out.println("Init method");
	}
	
	public void onDestroy() {
		System.out.println("Destory method");
	}
	
}