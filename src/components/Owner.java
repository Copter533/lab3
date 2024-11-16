package components;

import characters.Person;

public record Owner(Person who) implements Clarify {
    public String getPrefix() { return " "; }
    public String getSuffix() { return ""; }

    public String toString() {
        return "принадлежаший " + who;
    }
}
