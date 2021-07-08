package startcleaningup.after;

public class Astronaut {
    private String name;
    private int missions;

    public Astronaut(String name, int missions) {
        this.name = name;
        this.missions = missions;
    }

    public boolean isValid() {
        boolean isValidMissions = missions >= 0;
        boolean isValidName = name != null && !name.trim().isEmpty();
        return isValidMissions && isValidName;
    }
}
