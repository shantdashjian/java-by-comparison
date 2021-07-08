import org.junit.jupiter.api.Test;
import startcleaningup.after.Laboratory;
import startcleaningup.after.LaboratoryNegations;
import startcleaningup.after.Astronaut;
import startcleaningup.after.SpaceShip;
import startcleaningup.before.*;

import java.time.Duration;

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

    @Test
    void test_avoid_negations() {
        Microscope microscope = mock(Microscope.class);
        when(microscope.isOrganic(any(Sample.class))).thenReturn(false);
        LaboratoryNegations laboratoryNegations = new LaboratoryNegations(microscope);
        Sample sample = Sample.INORGANIC;

        Result result = laboratoryNegations.analyze(sample);

        assertThat(result).isEqualTo(Result.INORGANIC);
    }

    @Test
    void test_return_boolean_expressions_directly() {
        String name = "Tim";
        int missions = 1;
        Astronaut astronaut = new Astronaut(name, missions);

        assertThat(astronaut.isValid()).isTrue();
    }

    @Test
    void test_simplify_boolean_expressions() {
        Crew crew = mock(Crew.class);
        when(crew.getSize()).thenReturn(4);
        FuelTank fuelTank = mock(FuelTank.class);
        when(fuelTank.getFuel()).thenReturn(100);
        Hull hull = mock(Hull.class);
        when(hull.isIntact()).thenReturn(true);
        Navigator navigator = mock(Navigator.class);
        when(navigator.requiredFuelToEarth()).thenReturn(50);
        when(navigator.timeToEarth()).thenReturn(Duration.ofDays(1));
        OxygenTank oxygenTank = mock(OxygenTank.class);
        when(oxygenTank.lastsFor(crew.getSize())).thenReturn(Duration.ofDays(2));
        SpaceShip spaceShip = new SpaceShip(crew, fuelTank, hull, navigator, oxygenTank);

        assertThat(spaceShip.willCrewSurvive()).isTrue();
    }
}
