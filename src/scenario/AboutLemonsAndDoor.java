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
public class AboutLemonsAndDoor extends ScenarioAbstract {
    @Override String getName() { return "Про лемончиков и дверь"; }

    public void execute() {
        // Объекты ситуации
        Person he = new He();
        Person lemons = new Lemons();

        Addition door = new Addition("дверь");
        Addition jail = new Addition("тюрьма");

        Action rushTo = new RushTo(door);
        Action guard = new Guard(jail);

        Action banging = new Banging(door);
        banging.addClarify(new WithAllMight());
        banging.addClarify(new WithOwnFists());
        banging.setPrefix("стал");

        Action open = new Open(door);
        open.setPrefix("пока ему не");
        open.setOmitted(true);

        // Сама ситуация
        he.performNormal(rushTo, banging);

        lemons.addSubAction(guard);
        lemons.performReversed(open);
    }
}
