import java.util.List;

public interface ItemService {
    List<String> getItemsFromDatabase(String user);
    List<String> getItemsFromEmptyDatabase();
}
