package startcleaningup.after;

import startcleaningup.before.CruiseControl;
import startcleaningup.before.User;

import java.util.Objects;

public class BoardComputer {
    private final CruiseControl cruiseControl;

    public BoardComputer(CruiseControl cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public void authorize(User user) {
        Objects.requireNonNull(user);
        switch (user.getRank()) {
            case UNKNOWN:
                cruiseControl.logUnauthorizedAccessAttempt();
                break;
            case ASTRONAUT:
                cruiseControl.grantAccess(user);
                break;
            case COMMANDER:
                cruiseControl.grantAccess(user);
                cruiseControl.grantAdminAccess(user);
                break;
        }
    }
}
