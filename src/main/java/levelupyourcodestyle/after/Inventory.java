package levelupyourcodestyle.after;

import levelupyourcodestyle.before.Supply;

import java.util.Iterator;
import java.util.List;

public class Inventory {
    private final List<Supply> supplies;

    public Inventory(List<Supply> supplies) {
        this.supplies = supplies;
    }

    public List<Supply> getSupplies() {
        return supplies;
    }

    public void disposeContaminatedSupplies() {
        Iterator<Supply> iterator = supplies.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isContaminated()) {
                iterator.remove();
            }
        }
    }
}
