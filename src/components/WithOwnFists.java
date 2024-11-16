package components;

public record WithOwnFists() implements Clarify {
    public String getPrefix() { return " "; }
    public String getSuffix() { return ""; }

    public String toString() { return "своими кулаками"; }
}
