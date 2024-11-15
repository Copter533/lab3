package actions;

import components.Addition;

public class Guard extends ActionWithAddition {
    public Guard(Addition add) {
        super("сторожить", add);
    }
}
