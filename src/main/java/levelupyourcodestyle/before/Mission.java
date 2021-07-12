package levelupyourcodestyle.before;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Mission {

    private Temporal start;
    private Logbook logbook;

    public Mission(Logbook logbook, LocalDate start) {
        this.logbook = logbook;
        this.start = start;
    }

    public void update(String author, String message, String fileName) throws IOException {
        LocalDate today = LocalDate.now();
        String month = String.valueOf(today.getMonthValue());
        String formattedMonth = month.length() < 2 ? "0" + month : month;
        String entry = author.toUpperCase() + ": [" + formattedMonth + "-" +
                today.getDayOfMonth() + "-" + today.getYear() + "](Day " +
                (ChronoUnit.DAYS.between(start, today) + 1) + ")> " +
                message + System.lineSeparator();
        logbook.writeMessage(entry, Paths.get(fileName));
    }
}
