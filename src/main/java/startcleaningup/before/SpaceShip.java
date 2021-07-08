package startcleaningup.before;

public class SpaceShip {
    private final Crew crew;
    private final FuelTank fuelTank;
    private final Hull hull;
    private final Navigator navigator;
    private final OxygenTank oxygenTank;

    public SpaceShip(Crew crew, FuelTank fuelTank, Hull hull, Navigator navigator, OxygenTank oxygenTank) {
        this.crew = crew;
        this.fuelTank = fuelTank;
        this.hull = hull;
        this.navigator = navigator;
        this.oxygenTank = oxygenTank;
    }

    public boolean willCrewSurvive() {
        return hull.getHoles() == 0 &&
                fuelTank.getFuel() >= navigator.requiredFuelToEarth() &&
                oxygenTank.lastsFor(crew.getSize()).compareTo(navigator.timeToEarth()) > 0;
    }
}
