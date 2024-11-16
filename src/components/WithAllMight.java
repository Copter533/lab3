package components;

public record WithAllMight() implements Clarify {
    public String getPrefix() { return " "; }
    public String getSuffix() { return ""; }

    public String toString() { return "изо всех сил"; }
}
