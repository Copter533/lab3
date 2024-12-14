package components;

public record RightAfter(Addition after) implements Clarify {
    public String getPrefix() { return " "; }
    public String getSuffix() { return ""; }

    public String toString() {
        return "сейчас же после " + after;
    }
}
