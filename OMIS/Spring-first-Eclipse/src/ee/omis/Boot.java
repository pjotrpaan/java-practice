package ee.omis;

public class Boot implements Item {
	
	private ItemDatabaseService databaseService;
	
	public Boot() {
		System.out.println("Boot constructor called");
	}

	@Override
	public String getItemDescription() {
		// TODO Auto-generated method stub
		return "Item is BOOT";
	}

	@Override
	public String getFromDatabase() {
		// TODO Auto-generated method stub
		return databaseService.getItemFromDatabase();
	}

	public Boot(ItemDatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
	}

	public void setDatabaseService(ItemDatabaseService databaseService) {
		System.out.println("Boot DB service init");
		this.databaseService = databaseService;
	}

	

}
