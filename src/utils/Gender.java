package utils;

public enum Gender {
    MALE  ("он",  "который"),
    FEMALE("она", "которая"),
    THEY  ("они", "которые");

    public final String who;
    public final String that;
    Gender(String who, String that) {
        this.who  = who;
        this.that = that;
    }
}
