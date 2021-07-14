package usecommentswisely.before;

import levelupyourcodestyle.before.Supply;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    // Fields (we only have one)
    List<Supply> supplies = new ArrayList<>(); // The list of supplies.

    public Inventory(List<Supply> supplies) {
        this.supplies = supplies;
    }

    // Methods
    public int countContaminatedSupplies() {
        // TODO: check if field is already initialized (not null)
        int contaminatedCounter = 0; // the counter
// No supplies => no contamination
        for (Supply supply : supplies) { // begin FOR
            if (supply.isContaminated()) {
                contaminatedCounter++; // increment counter!
            } // End IF supply is contaminated
        }// End FOR
        // Returns the number of contaminated supplies.
        return contaminatedCounter; // Handle with care!
    }
} // End of Inventory class