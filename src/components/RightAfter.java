package components;

public record RightAfter(Addition after) implements Clarify {
    public String getPrefix() { return "на "; }
    public String getSuffix() { return ""; }

    public String toString() {
        return "сейчас же после " + after;
    }
}
