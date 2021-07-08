import org.junit.jupiter.api.Test;
import startcleaningup.after.Laboratory;
import startcleaningup.before.Microscope;
import startcleaningup.before.Sample;
import startcleaningup.before.Result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartCleaningUpTests {

    @Test
    void test_avoid_unnecessary_comparisons_inorganic() {
        Microscope microscope = mock(Microscope.class);
        when(microscope.isInorganic(any(Sample.class))).thenReturn(true);
        Laboratory laboratory = new Laboratory(microscope);
        Sample sample = Sample.INORGANIC;

        Result result = laboratory.analyze(sample);

        assertThat(result).isEqualTo(Result.INORGANIC);
    }

    @Test
    void test_avoid_unnecessary_comparisons_alien() {
        Microscope microscope = mock(Microscope.class);
        when(microscope.isInorganic(any(Sample.class))).thenReturn(false);
        when(microscope.isHumanoid(any(Sample.class))).thenReturn(false);
        Laboratory laboratory = new Laboratory(microscope);
        Sample sample = Sample.ALIEN;

        Result result = laboratory.analyze(sample);

        assertThat(result).isEqualTo(Result.ALIEN);
    }

    @Test
    void test_avoid_unnecessary_comparisons_humanoid() {
        Microscope microscope = mock(Microscope.class);
        when(microscope.isInorganic(any(Sample.class))).thenReturn(false);
        when(microscope.isHumanoid(any(Sample.class))).thenReturn(true);
        Laboratory laboratory = new Laboratory(microscope);
        Sample sample = Sample.HUMANOID;

        Result result = laboratory.analyze(sample);

        assertThat(result).isEqualTo(Result.HUMANOID);
    }
}
