package components;

import java.util.ArrayList;

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

}
