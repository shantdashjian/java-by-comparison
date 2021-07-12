package levelupyourcodestyle.after;

import levelupyourcodestyle.before.Logbook;

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
        String entry = String.format("%S: [%tm-%<te-%<tY](Day %d)> %s%n",
                author, today,
                (ChronoUnit.DAYS.between(start, today) + 1), message);
        logbook.writeMessage(entry, Paths.get(fileName));
    }
}
