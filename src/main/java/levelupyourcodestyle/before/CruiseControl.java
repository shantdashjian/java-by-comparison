package levelupyourcodestyle.before;

public class CruiseControl {

    private double targetSpeedKmh;

    public void setPreset(int speedPreset) {
        if (speedPreset == 2) {
            setTargetSpeedKmh(16944);
        } else if (speedPreset == 1) {
            setTargetSpeedKmh(7667);
        } else if (speedPreset == 0) {
            setTargetSpeedKmh(0);
        }
    }

    void setTargetSpeedKmh(double speed) {
        targetSpeedKmh = speed;
    }

    public double getTargetSpeedKmh() {
        return targetSpeedKmh;
    }
}
