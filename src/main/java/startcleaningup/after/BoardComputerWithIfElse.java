package startcleaningup.after;

import startcleaningup.before.CruiseControl;
import startcleaningup.before.User;

import java.util.Objects;

public class BoardComputerWithIfElse {

    private final CruiseControl cruiseControl;

    public BoardComputerWithIfElse(CruiseControl cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public void authorize(User user) {
        Objects.requireNonNull(user);
        if (user.isUnknown()) {
            cruiseControl.logUnauthorizedAccessAttempt();
            return;
        }

        if (user.isAstronaut()) {
            cruiseControl.grantAccess(user);
        } else if (user.isCommander()) {
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
        }
    }
}
