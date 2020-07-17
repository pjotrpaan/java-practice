import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    ItemService itemService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getPlatinumItems() {
        ItemServiceStub itemServiceStub = new ItemServiceStub();
        Item item = new Item(itemServiceStub);

        List<String> platinumTestList = item.platinumItemsTestIsCorrect_WhenServiceStubIsUsed("player");
        assertEquals(3, platinumTestList.size());
    }
    @Test
    public List<String> platinumItemsTestIsCorrect_WhenServiceStubIsUsed(String user) {
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