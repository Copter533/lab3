package scenario;
// Кавалера немедленно доставили в замок.

import actions.*;
import characters.Cavalier;
import characters.Person;
import components.Addition;

// Конкретный сценарий
public class AboutCavalier extends ScenarioAbstract {
    @Override String getName() { return "Про кавалера в замке"; }

    public void execute() {
        // Объекты ситуации
        Person cavalier = new Cavalier();

        Addition castle = new Addition("замок");

        Action getTo = new GetTo(castle);
        getTo.setPrefix("немедлено");

        cavalier.performOn(getTo);
    }
}
