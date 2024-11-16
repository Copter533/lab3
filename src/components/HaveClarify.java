package components;

import java.util.ArrayList;

public interface HaveClarify {
    void addClarify(Clarify clarify);

    static String getClarifiesString(ArrayList<Clarify> clarifies) {
        if (clarifies.isEmpty()) return "";

        StringBuilder result = new StringBuilder(clarifies.get(0).getPrefix());
        for (int i = 0; i < clarifies.size(); i++) {
            if (i != 0) result.append(", ");
            result.append(clarifies.get(i));
        }
        result.append(clarifies.get(clarifies.size() - 1).getSuffix());

        return result.toString();
    }
}