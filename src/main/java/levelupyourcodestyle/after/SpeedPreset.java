package levelupyourcodestyle.after;

public enum SpeedPreset {
    CRUISE_SPEED(16944),
    PLANETARY_SPEED(7667),
    STOP_SPEED(0);

    final double speedKmh;

    SpeedPreset(double speedKmh) {
        this.speedKmh = speedKmh;
    }

    public double getSpeedKmh() {
        return speedKmh;
    }
}
