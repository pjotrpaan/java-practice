package ee.omis;
import org.springframework.stereotype.Component;

@Component
public class ItemFromMySQLDb implements ItemFromDb {

	@Override
	public String getAllItemsFromDb() {
		// TODO Auto-generated method stub
		return "Get all items from db initiated";
	}

}
