package components;

import scenario.Scenario;

import java.util.Random;

public enum Gender {
    MALE  ("он",  "который", "был"),
    FEMALE("она", "которая", "была"),
    THEY  ("они", "которые", "были");

    public final String who;
    public final String that;
    public final String was;

    Gender(String who, String that, String was) {
        this.who  = who;
        this.that = that;
        this.was  = was;
    }

    public static Gender random(Gender unchanged) {
        if (!Scenario.isCurrentRandom) return unchanged;
        return switch (new Random().nextInt() % 10) {
            case 0  -> MALE;
            case 1  -> FEMALE;
            case 2  -> THEY;
            default -> unchanged;
        };
    }
}
