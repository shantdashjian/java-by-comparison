package levelupyourcodestyle.before;

import java.util.Arrays;
import java.util.List;

public class LaunchCheckList {
    List<String> checks = Arrays.asList("Cabin Pressure",
            "Communication",
            "Engine");

    public Status prepareForTakeoff(Commander commander) {
        for (int i = 0; i < checks.size(); i++) {
            boolean shouldAbortTakeoff = commander.isFailing(checks.get(i));
            if (shouldAbortTakeoff) {
                return Status.ABORT_TAKE_OFF;
            }
        }
        return Status.READY_FOR_TAKE_OFF;
    }
}
