package actions;

import components.Addition;

public class Open extends ActionWithAddition {
    public Open(Addition add) {
        super("открыть", add);
    }
}
