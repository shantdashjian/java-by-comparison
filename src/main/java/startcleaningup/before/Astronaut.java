package startcleaningup.before;

public class Astronaut {
    private String name;
    private int missions;

    public Astronaut(String name, int missions) {
        this.name = name;
        this.missions = missions;
    }

    public boolean isValid() {
        if (missions < 0 || name == null || name.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
