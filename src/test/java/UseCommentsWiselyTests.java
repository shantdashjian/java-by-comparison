import levelupyourcodestyle.before.Commander;
import levelupyourcodestyle.before.Status;
import levelupyourcodestyle.before.Supply;
import org.junit.jupiter.api.Test;
import usecommentswisely.after.Inventory;
import usecommentswisely.after.LaunchCheckList;
import usecommentswisely.after.SmallDistanceUnit;
import usecommentswisely.after.FuelSystem;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UseCommentsWiselyTests {

    @Test
    void test_remove_superfluous_comments() {
        List<Supply> supplies = new ArrayList<>();
        supplies.add(new Supply(true));
        supplies.add(new Supply(false));
        Inventory inventory = new Inventory(supplies);

        assertThat(inventory.countContaminatedSupplies()).isEqualTo(1);
    }

    @Test
    void test_remove_commented_out_code() {
        LaunchCheckList launchCheckList = new LaunchCheckList();
        Commander commander = mock(Commander.class);
        when(commander.isFailing(anyString())).thenReturn(true);

        assertThat(launchCheckList.prepareLaunch(commander)).isEqualTo(Status.ABORT_TAKE_OFF);
    }

    @Test
    void test_replace_comments_with_constants() {
        assertThat(SmallDistanceUnit.CENTIMETER
                .getConversionRate(SmallDistanceUnit.CENTIMETER))
                .isCloseTo(1, within(0.01));
    }

    @Test
    void test_replace_comments_with_utility_methods() {
        List<Double> tanks = new ArrayList<>();
        tanks.add(1.00);
        tanks.add(1.00);
        tanks.add(1.00);
        FuelSystem fuelSystem = new FuelSystem(tanks);

        assertThat(fuelSystem.getAverageTankFillingPercent()).isEqualTo(100);
    }
}
