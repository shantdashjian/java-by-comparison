package usecommentswisely.after;

import java.util.List;

public class FuelSystem {

    private final List<Double> tanks;

    public FuelSystem(List<Double> tanks) {
        this.tanks = tanks;
    }

    public int getAverageTankFillingPercent() {
        double sum = 0;
        for (double tankFilling : tanks) {
            sum += tankFilling;
        }
        double averageFuel = sum / tanks.size();
        return roundToIntegerPercent(averageFuel);
    }

    private int roundToIntegerPercent(double value) {
        return Math.toIntExact(Math.round(value * 100));
    }
}
