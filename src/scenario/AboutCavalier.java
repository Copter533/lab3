package scenario;
// Кавалера немедленно доставили в замок.

import actions.*;
import characters.Cavalier;
import characters.Person;
import components.Addition;

// Конкретный сценарий
public class AboutCavalier extends Scenario {
    @Override String getName() { return "Про кавалера в замке"; }

    public void execute() {
        // Объекты ситуации
        Person cavalier = new Cavalier();

        Addition castle = new Addition("замок");

        Action get_to = new GetTo(castle);
        get_to.setPrefix("немедлено");

        cavalier.performOn(get_to);
    }
}
