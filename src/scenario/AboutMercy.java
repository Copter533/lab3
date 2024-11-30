package scenario;
// Он рассказал принцу все, что узнал от синьора Горошка, и добился прощения.

import actions.Achieve;
import actions.Action;
import actions.TellTo;
import characters.He;
import characters.Person;
import characters.Prince;
import characters.SirPot;
import components.Addition;
import components.KnewFrom;

// Конкретный сценарий
public class AboutMercy extends Scenario {
    @Override String getName() { return "Про прощение"; }

    public void execute() {
        // Объекты ситуации
        Person he = new He();
        Person prince = new Prince();
        Person sirPot = new SirPot();

        Addition mercy = new Addition("прощения");

        Addition everything = new Addition("всё");
        everything.addClarify(new KnewFrom(sirPot));

        Action tell_to = new TellTo(everything, prince);
        Action achieve = new Achieve(mercy);

        he.perform(tell_to, achieve);
    }
}
