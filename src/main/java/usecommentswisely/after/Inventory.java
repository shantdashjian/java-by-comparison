package usecommentswisely.after;

import levelupyourcodestyle.before.Supply;

import java.util.List;
import java.util.Objects;

public class Inventory {

    List<Supply> supplies;

    public Inventory(List<Supply> supplies) {
        this.supplies = supplies;
    }

    public int countContaminatedSupplies() {
        if (supplies == null || supplies.isEmpty()) {
            // No supplies => no contamination
            return 0;
        }

        int contaminatedCounter = 0;
        for (Supply supply : supplies) {
            if (supply.isContaminated()) {
                contaminatedCounter++;
            }
        }
        return contaminatedCounter;
    }
}