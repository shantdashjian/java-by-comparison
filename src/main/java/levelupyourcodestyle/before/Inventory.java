package levelupyourcodestyle.before;

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
        for (Supply supply : supplies) {
            if (supply.isContaminated()) {
                supplies.remove(supply);
            }
        }
    }
}
