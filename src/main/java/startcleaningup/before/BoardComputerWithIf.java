package startcleaningup.before;

import java.util.Objects;

public class BoardComputerWithIf {
    private final CruiseControl cruiseControl;

    public BoardComputerWithIf(CruiseControl cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public void authorize(User user) {
        Objects.requireNonNull(user);
        if (user.isUnknown())
            cruiseControl.logUnauthorizedAccessAttempt();
        if (user.isAstronaut())
            cruiseControl.grantAccess(user);
        if (user.isCommander())
            cruiseControl.grantAccess(user);
        cruiseControl.grantAdminAccess(user);
    }
}
