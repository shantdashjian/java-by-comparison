package levelupyourcodestyle.before;

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
        for (Supply supply : supplies) {
            if (Pattern.matches(regex, supply.toString())) {
                result.add(supply);
            }
        }
        return result;
    }
}
