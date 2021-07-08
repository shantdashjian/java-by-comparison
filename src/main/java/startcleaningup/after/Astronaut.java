package startcleaningup.after;

public class Astronaut {
    private String name;
    private int missions;

    public Astronaut(String name, int missions) {
        this.name = name;
        this.missions = missions;
    }

    public boolean isValid() {
        return missions >= 0 && name != null && !name.trim().isEmpty();
    }
}
