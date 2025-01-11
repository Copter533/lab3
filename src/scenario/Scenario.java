package scenario;

public class Scenario {
    private final String name;
    private final Runnable action;

    public static boolean isCurrentRandom = true;

    public Scenario(String name, Runnable action, boolean randomness) {
        this.name       = name;
        this.action     = action;

        Scenario.isCurrentRandom = randomness;
    }

    public void run() {
        System.out.printf("\n [S] ===== Ситуация \"%s\" ===== [S] \n\n", name);
        action.run();
        System.out.print("\n\n\n\n\n");
    }

    public static class Builder {
        String name;
        private Runnable action;
        private boolean randomness = true;

        public Builder(String name) {
            this.name = name;
        }

        public Builder action(Runnable action) {
            this.action = action;
            return this;
        }

        public Builder randomness(boolean flag) {
            this.randomness = flag;
            return this;
        }

        public Scenario build() {
            if (name == null || name.trim().isBlank()) {
                throw new IllegalStateException("Имя нужно указать");
            }if (action == null) {
                throw new IllegalStateException("Действия нужно указать");
            }
            return new Scenario(name, action, randomness);
        }
    }
}
