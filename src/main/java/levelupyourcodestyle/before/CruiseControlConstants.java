package levelupyourcodestyle.before;

public class CruiseControlConstants {

    public static final int CRUISE_SPEED_PRESET = 2;
    public static final int PLANETARY_SPEED_PRESET = 1;
    public static final int STOP_PRESET = 0;

    public static final int CRUISE_SPEED_KMH = 16944;
    public static final int PLANETARY_SPEED_KMH = 7667;
    public static final int STOP_SPEED_KMH = 0;

    private double targetSpeedKmh;

    public void setPreset(int speedPreset) {
        if (speedPreset == CRUISE_SPEED_PRESET) {
            setTargetSpeedKmh(CRUISE_SPEED_KMH);
        } else if (speedPreset == PLANETARY_SPEED_PRESET) {
            setTargetSpeedKmh(PLANETARY_SPEED_KMH);
        } else if (speedPreset == STOP_PRESET) {
            setTargetSpeedKmh(STOP_SPEED_KMH);
        }
    }

    void setTargetSpeedKmh(double speed) {
        targetSpeedKmh = speed;
    }

    public double getTargetSpeedKmh() {
        return targetSpeedKmh;
    }
}
