package scenario;
// Он бросился к двери и стал изо всех сил колотить в нее кулаками,
// пока ему не открыли Лимончики, сторожившие тюрьму.

import actions.*;
import characters.He;
import characters.Lemons;
import characters.Person;
import components.Addition;
import components.WithAllMight;
import components.WithOwnFists;

// Конкретный сценарий
public class AboutLemonsAndDoor extends Scenario {
    @Override String getName() { return "Про лемончиков и дверь"; }

    public void execute() {
        // Объекты ситуации
        Person he = new He();
        Person lemons = new Lemons();

        Addition door = new Addition("дверь");
        Addition jail = new Addition("тюрьма");

        RushTo rush_to = new RushTo(door);
        Guard guard = new Guard(jail);

        Banging banging = new Banging(door);
        banging.addClarify(new WithAllMight());
        banging.addClarify(new WithOwnFists());
        banging.setPrefix("стал");

        Open open = new Open(door);
        open.setPrefix("пока ему не");
        open.setOmitted(true);

        // Сама ситуация
        he.perform(rush_to, banging);

        lemons.addSubAction(guard);
        lemons.perform_reversed(open);
    }
}
