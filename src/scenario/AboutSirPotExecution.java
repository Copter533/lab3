package scenario;
// Принц Лимон был очень доволен и приказал своим Лимончикам на следующее утро
// -- сейчас же после казни синьора Горошка --
// отправиться в лес и привезти оттуда домик кума Тыквы.

import actions.*;
import characters.*;
import components.*;

public class AboutSirPotExecution extends Scenario {
    @Override String getName() { return "Про казнь синьора Горшка"; }

    public void execute() {
        // Объекты ситуации
        Person prince  = new PrinceLemon();
        Person lemons  = new Lemons();
        Person sir_pot = new SirPot();
        Person kum     = new PumpkinKum();

        Addition house = new Addition("домик");
        house.addClarify(new Owner(kum));

        Addition forest = new Addition("лес");
        Addition execution = new Execute(sir_pot).toAddition();

        Action goTo    = new GoTo(forest);
        Action getWhat = new GetWhat(house);

        Action order = new Ordered(lemons, goTo, getWhat);
        order.addClarify(new NextMorning());
        order.addClarify(new RightAfter(execution));

        prince.addClarify(new Satisfied());
        try {
            prince.getState();
        } catch (NoStateException ignored) {}
        prince.perform(order);
    }
}
