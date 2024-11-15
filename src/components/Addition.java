package components;

public record Addition(String name) {
    @Override
    public String toString() {
        return this.name;
    }
}
