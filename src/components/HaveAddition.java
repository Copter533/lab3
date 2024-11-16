package components;

import java.util.ArrayList;

public interface HaveAddition {
    void addAddition(Addition add);

    static String getAdditionsString(ArrayList<Addition> additions) {
        if (additions.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < additions.size(); i++) {
            if (i != 0) result.append(", ");
            result.append(additions.get(i));
        }

        return result.toString();
    }
}