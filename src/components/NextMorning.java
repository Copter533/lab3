package components;

public record NextMorning() implements Clarify {
    public String getPrefix() { return "на "; }
    public String getSuffix() { return ""; }

    public String toString() {
        return "следующее утро";
    }
}
