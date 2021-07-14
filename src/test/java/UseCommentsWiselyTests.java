import levelupyourcodestyle.before.Supply;
import org.junit.jupiter.api.Test;
import usecommentswisely.after.Inventory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UseCommentsWiselyTests {

    @Test
    void test_remove_superfluous_comments() {
        List<Supply> supplies = new ArrayList<>();
        supplies.add(new Supply(true));
        supplies.add(new Supply(false));
        Inventory inventory = new Inventory(supplies);

        assertThat(inventory.countContaminatedSupplies()).isEqualTo(1);
    }
}
