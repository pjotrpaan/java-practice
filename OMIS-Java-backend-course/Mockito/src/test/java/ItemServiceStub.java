import java.util.Arrays;
import java.util.List;

public class ItemServiceStub implements ItemService {
    @Override
    public List<String> getItemsFromDatabase(String user) {
        return Arrays.asList("Hammer - platinum",
                "Hammer1 - gold",
//                "Sword2 - platinum",
                "Hammer2 - gold",
                "Sword2 - platinum");
    }

    @Override
    public List<String> getItemsFromEmptyDatabase() {
        return Arrays.asList();
    }
}
