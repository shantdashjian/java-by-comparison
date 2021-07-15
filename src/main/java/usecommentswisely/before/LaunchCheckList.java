package usecommentswisely.before;

import levelupyourcodestyle.before.Commander;
import levelupyourcodestyle.before.Status;

import java.util.Arrays;
import java.util.List;

public class LaunchCheckList {

    List<String> checks = Arrays.asList(
            "Cabin Leak",

            // "Communication", // Do we actually want to talk to Houston?
            "Engine",
            "Hull",

            // "Rover", // We won't need it, I think...
            "OxygenTank"

            //"Supplies"
    );

    public Status prepareLaunch(Commander commander) {
        for (String check : checks) {
            boolean shouldAbortTakeoff = commander.isFailing(check);
            if (shouldAbortTakeoff) {

                //System.out.println("REASON FOR ABORT: " + item);
                return Status.ABORT_TAKE_OFF;
            }
        }
        return Status.READY_FOR_TAKE_OFF;
    }
}
