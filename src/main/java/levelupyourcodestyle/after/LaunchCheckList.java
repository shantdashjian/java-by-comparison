package levelupyourcodestyle.after;

import levelupyourcodestyle.before.Commander;
import levelupyourcodestyle.before.Status;

import java.util.Arrays;
import java.util.List;

public class LaunchCheckList {

    List<String> checks = Arrays.asList("Cabin Pressure",
            "Communication",
            "Engine");

    public Status prepareForTakeoff(Commander commander) {
        for (String check : checks) {
            boolean shouldAbortTakeoff = commander.isFailing(check);
            if (shouldAbortTakeoff) {
                return Status.ABORT_TAKE_OFF;
            }
        }
        return Status.READY_FOR_TAKE_OFF;
    }
}
