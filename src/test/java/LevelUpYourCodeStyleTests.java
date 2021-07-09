import levelupyourcodestyle.after.CruiseControl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LevelUpYourCodeStyleTests {
    public static final int CRUISE_SPEED_PRESET = 2;

    public static final int CRUISE_SPEED_KMH = 16944;

    @Test
    void test_replace_magic_numbers_with_constants() {
        CruiseControl cruiseControl = new CruiseControl();

        cruiseControl.setPreset(CRUISE_SPEED_PRESET);

        assertThat(cruiseControl.getTargetSpeedKmh()).isCloseTo(CRUISE_SPEED_KMH, within(0.1));
    }
}
