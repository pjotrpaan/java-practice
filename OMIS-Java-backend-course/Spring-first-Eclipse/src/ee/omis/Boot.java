package ee.omis;

public class Boot implements Item {
	private String level;
	private int endurance;
	
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

	
	
	public String getLevel() {
		return level;
	}

	public int getEndurance() {
		return endurance;
	}

	public Boot(ItemDatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
	}

	public void setDatabaseService(ItemDatabaseService databaseService) {
		System.out.println("Boot DB service init");
		this.databaseService = databaseService;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public String setLevel(String level) {
		this.level = level;
		return level;
	}

}
