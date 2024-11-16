package components;

public record Satisfied() implements Clarify {
    public String getPrefix() { return " "; }
    public String getSuffix() { return ""; }

    public String toString() {
        return "очень доволен";
    }
}
