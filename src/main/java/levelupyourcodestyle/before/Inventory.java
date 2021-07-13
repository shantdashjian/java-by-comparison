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

    public int getQuantity(Supply supply) {
        if (supply == null) {
            throw new NullPointerException("supply must not be null");
        }
        int quantity = 0;
        for (Supply supplyInStock : supplies) {
            if (supply.equals(supplyInStock)) {
                quantity++;
            }
        }
        return quantity;
    }
}
