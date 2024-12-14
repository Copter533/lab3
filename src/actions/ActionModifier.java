package actions;

import scenario.Scenario;

import java.util.Random;

public enum ActionModifier {
    NORMAL,
    REVERSED,
    TARGETED;

    private static ActionModifier random() {
        return random(-1);
    }

    public static ActionModifier random(ActionModifier skip) {
        return random(switch (skip) {
            case NORMAL   -> 0;
            case REVERSED -> 1;
            case TARGETED -> 2;
        });
    }

    private static ActionModifier random(int to_skip) {
        if (!Scenario.isCurrentRandom) throw new IllegalStateException(
                "Нельзя получать случайный модификатоор действия с выключенной случайностью в настройках!"
        );

        int v;
        if (to_skip >= 0) {
            v = new Random().nextInt(2);
            if (v == to_skip) v++;
        } else {
            v = new Random().nextInt(3);
        }
        return switch (v) {
            case 0 -> NORMAL;
            case 1 -> REVERSED;
            case 2 -> TARGETED;
            default -> null;
        };
    }
}
