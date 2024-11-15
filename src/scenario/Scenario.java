package scenario;

abstract public class Scenario {
    abstract String getName();

    void begin() {
        System.out.printf(" [X] ===== Ситуация \"%s\" ===== [X] \n\n", getName());
        execute();
        System.out.print("\n [X] ===== Конец ситуации ===== [X] \n");
    }

    abstract void execute();
}