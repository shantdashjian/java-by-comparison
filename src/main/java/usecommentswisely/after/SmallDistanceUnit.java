package usecommentswisely.after;

public enum SmallDistanceUnit {

    CENTIMETER,
    INCH;

    public static final int IDENTITY = 1;
    public static final double INCH_IN_CENTIMETERS = 2.54;
    public static final double CENTIMETER_IN_INCHES = 1 / INCH_IN_CENTIMETERS;

    public double getConversionRate(SmallDistanceUnit unit) {
        if (this == unit) {
            return IDENTITY;
        }
        if (this == CENTIMETER && unit == INCH) {
            return CENTIMETER_IN_INCHES;
        } else {
            return INCH_IN_CENTIMETERS;
        }
    }
}
