package usecommentswisely.before;

import levelupyourcodestyle.before.Supply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryFast {
    private List<Supply> list = new ArrayList<>();

    public void add(Supply supply) {
        list.add(supply);
        Collections.sort(list);
    }


    public boolean isInStock(String name) {
        // fast implementation
        return Collections.binarySearch(list, new Supply(true, name)) != -1;
    }
}
