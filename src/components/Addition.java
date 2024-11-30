package components;

import java.util.ArrayList;
import java.util.Objects;

public class Addition implements HaveClarify {
    ArrayList<Clarify> clarifies = new ArrayList<>();
    String name;

    public Addition(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (clarifies.isEmpty()) return name;
        return name + HaveClarify.getClarifiesString(clarifies);
    }

    public void addClarify(Clarify clarify) {
        clarifies.add(clarify);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(name, ((Addition) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clarifies, name);
    }
}
