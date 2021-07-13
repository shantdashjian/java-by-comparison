package levelupyourcodestyle.after;

import levelupyourcodestyle.before.Supply;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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

    public int getQuantity(Supply supply) {
        Objects.requireNonNull(supply, "supply must not be null");

        return Collections.frequency(supplies, supply);
    }
}
