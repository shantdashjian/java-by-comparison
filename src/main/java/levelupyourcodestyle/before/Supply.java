package levelupyourcodestyle.before;

public class Supply {
    private final boolean contaminated;
    private String name;

    public Supply(boolean contaminated) {
        this.contaminated = contaminated;
    }

    public Supply(boolean contaminated, String name) {
        this.contaminated = contaminated;
        this.name = name;
    }

    public boolean isContaminated() {
        return contaminated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "contaminated=" + contaminated +
                ", name='" + name + '\'' +
                '}';
    }
}
