package scenario;

import java.util.Objects;

abstract public class ScenarioAbstract {
    abstract String getName();

    final void begin() {
        System.out.printf("\n [S] ===== Ситуация \"%s\" ===== [S] \n\n", getName());
        execute();
        System.out.print("\n\n\n\n\n");
    }

    abstract void execute();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScenarioAbstract sce)
            return sce.getName().equals(getName());
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}