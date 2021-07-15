package usecommentswisely.after;

import levelupyourcodestyle.before.Supply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryFast {
    // Keep this list sorted. See isInStock().
    private List<Supply> list = new ArrayList<>();

    public void add(Supply supply) {
        list.add(supply);
        Collections.sort(list);
    }


    public boolean isInStock(String name) {
        /*
         * In the context of checking availability of supplies by name,
         * facing severe performance issues with >1000 supplies
         * we decided to use the binary search algorithm
         * to achieve item retrieval within 1 second,
         * accepting that we must keep the supplies sorted.
         */
        return Collections.binarySearch(list, new Supply(true, name)) != -1;
    }
}
