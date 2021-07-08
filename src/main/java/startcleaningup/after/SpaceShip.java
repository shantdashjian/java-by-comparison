package startcleaningup.after;

import startcleaningup.before.*;

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
        boolean hasEnoughResources = hasEnoughFuel() && hasEnoughOxygen();
        return hull.isIntact() && hasEnoughResources;
    }

    private boolean hasEnoughOxygen() {
        return oxygenTank.lastsFor(crew.getSize()).compareTo(navigator.timeToEarth()) > 0;
    }

    private boolean hasEnoughFuel() {
        return fuelTank.getFuel() >= navigator.requiredFuelToEarth();
    }
}
