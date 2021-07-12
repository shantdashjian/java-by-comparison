import levelupyourcodestyle.after.CruiseControl;
import levelupyourcodestyle.after.CruiseControlConstants;
import levelupyourcodestyle.after.LaunchCheckList;
import levelupyourcodestyle.after.SpeedPreset;
import levelupyourcodestyle.after.Mission;
import levelupyourcodestyle.before.*;
import levelupyourcodestyle.after.Inventory;
import levelupyourcodestyle.after.InventoryComputeIntense;
import levelupyourcodestyle.after.DistanceUnit;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LevelUpYourCodeStyleTests {

    public static final int CRUISE_SPEED_PRESET = 2;

    public static final int CRUISE_SPEED_KMH = 16944;

    @Test
    void test_replace_magic_numbers_with_constants() {
        CruiseControl cruiseControl = new CruiseControl();

        cruiseControl.setPreset(CRUISE_SPEED_PRESET);

        assertThat(cruiseControl.getTargetSpeedKmh()).isCloseTo(CRUISE_SPEED_KMH, within(0.1));
    }

    @Test
    void test_favor_enums_over_constants() {
        CruiseControlConstants cruiseControlConstants = new CruiseControlConstants();

        cruiseControlConstants.setPreset(SpeedPreset.CRUISE_SPEED);

        assertThat(cruiseControlConstants.getTargetSpeedKmh()).isCloseTo(SpeedPreset.CRUISE_SPEED.getSpeedKmh(),
                within(0.1));
    }

    @Test
    void test_favor_for_each_over_for_loops() {
        Commander commander = mock(Commander.class);
        when(commander.isFailing(anyString())).thenReturn(true);
        LaunchCheckList launchCheckList = new LaunchCheckList();

        assertThat(launchCheckList.prepareForTakeoff(commander)).isEqualTo(Status.ABORT_TAKE_OFF);
    }

    @Test
    void test_avoid_collection_modification_during_iteration() {
        List<Supply> supplies = new ArrayList();
        supplies.add(new Supply(false));
        supplies.add(new Supply(false));
        Inventory inventory = new Inventory(supplies);
        supplies.add(new Supply(true));

        inventory.disposeContaminatedSupplies();

        assertThat(inventory.getSupplies().size()).isEqualTo(2);
    }

    @Test
    void test_avoid_compute_intense_operations_during_iteration() {
        List<Supply> supplies = new ArrayList();
        supplies.add(new Supply(false, "food"));
        supplies.add(new Supply(false, "water"));
        supplies.add(new Supply(true, "oxygen"));
        InventoryComputeIntense inventoryComputeIntense = new InventoryComputeIntense(supplies);

        assertThat(inventoryComputeIntense.find(".*food.*").size()).isEqualTo(1);
    }

    @Test
    void test_group_with_new_lines() {
        DistanceUnit thisDistanceUnit = DistanceUnit.MILES;
        DistanceUnit otherDistanceUnit = DistanceUnit.MILES;

        assertThat(thisDistanceUnit.getConversionRate(otherDistanceUnit)).isCloseTo(1.0, within(0.1));
    }

    @Test
    void test_favor_format_over_concatenation() throws IOException {
        Logbook logbook = mock(Logbook.class);
        Mission mission = new Mission(logbook, LocalDate.now());

        mission.update("Tim Brown", "Be brave!", "logbook.txt");

        verify(logbook).writeMessage(anyString(), any(Path.class));
    }
}
