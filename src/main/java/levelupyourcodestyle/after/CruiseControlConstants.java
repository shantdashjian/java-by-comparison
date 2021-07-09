package levelupyourcodestyle.after;

import java.util.Objects;

public class CruiseControlConstants {

    private double targetSpeedKmh;

    public void setPreset(SpeedPreset speedPreset) {
        Objects.requireNonNull(speedPreset);

        setTargetSpeedKmh(speedPreset.getSpeedKmh());
    }

    void setTargetSpeedKmh(double speed) {
        targetSpeedKmh = speed;
    }

    public double getTargetSpeedKmh() {
        return targetSpeedKmh;
    }
}
