package levelupyourcodestyle.before;

import java.util.Objects;

public class Supply implements Comparable<Supply>{
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supply supply = (Supply) o;
        return contaminated == supply.contaminated && name.equals(supply.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contaminated, name);
    }

    @Override
    public int compareTo(Supply o) {
        return this.getName().compareTo(o.getName());
    }
}
