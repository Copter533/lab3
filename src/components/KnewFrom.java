package components;

import characters.Person;

public record KnewFrom(Person who) implements Clarify {
    public String getPrefix() { return ", что "; }
    public String getSuffix() { return ""; }

    public String toString() {
        return "узнал от " + who;
    }
}
