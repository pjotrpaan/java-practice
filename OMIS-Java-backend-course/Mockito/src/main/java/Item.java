import java.util.ArrayList;
import java.util.List;

public class Item {
    ItemService itemService;

    public Item(ItemService itemService) {
        this.itemService = itemService;
    }

    public List<String> getPlatinumItems(String user) {
        List<String> platinumItems = new ArrayList<>();
        List<String> allItems = itemService.getItemsFromDatabase(user);
        for (String item:allItems) {
            if (item.contains("platinum")){
                platinumItems.add(item);
            }
        }
        return platinumItems;
    }


}
