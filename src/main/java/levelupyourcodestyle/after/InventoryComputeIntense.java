package levelupyourcodestyle.after;

import levelupyourcodestyle.before.Supply;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class InventoryComputeIntense {
    private List<Supply> supplies;

    public InventoryComputeIntense(List<Supply> supplies) {
        this.supplies = supplies;
    }


    public List<Supply> find(String regex) {
        List<Supply> result = new LinkedList<>();
        Pattern pattern = Pattern.compile(regex);
        for (Supply supply : supplies) {
            if (pattern.matcher(supply.toString()).matches()) {
                result.add(supply);
            }
        }
        return result;
    }
}
