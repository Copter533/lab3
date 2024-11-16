package components;

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
}
