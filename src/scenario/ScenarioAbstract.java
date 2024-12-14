package scenario;

abstract public class ScenarioAbstract {
    abstract String getName();

    final void begin() {
        System.out.printf("\n [S] ===== Ситуация \"%s\" ===== [S] \n\n", getName());
        execute();
        System.out.print("\n\n\n\n\n");
    }

    abstract void execute();
}