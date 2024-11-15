package scenario;

// Конкретный сценарий
public class AboutLemonsAndDoor extends Scenario {
    @Override String getName() { return "Про лемончиков и дверь"; }

    public void execute() {
        System.out.println("Делаем дела");
    }
}
