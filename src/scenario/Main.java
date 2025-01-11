package scenario;

import actions.*;
import characters.*;
import components.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new AboutLemonsAndDoor().begin();

        new AboutCavalier().begin();

        new AboutMercy().begin();

        new AboutSirPotExecution().begin();

        new Scenario.Builder("Полная случайность").action(() -> {
            List<Class<? extends Person>> classes =
                    List.of(He.class, Cavalier.class, Lemons.class, Prince.class,
                            PrinceLemon.class, PumpkinKum.class, SirPot.class);

            List<Person> characters = classes.stream()
                    .map(Person::createInstance)
                    .toList();

            List<Addition> additions = List.of(
                    new Addition("замок"),
                    new Addition("кухня"),
                    new Addition("сад"),
                    new Addition("подвал"),
                    new Addition("лес"),
                    new Addition("башня"),
                    new Addition("деревня"),
                    new Addition("пещера")
            );

            ArrayList<Action> actions = new ArrayList<>();
            for (int i = 0; i <= 10; i++) {
                Action act = Utils.randomAction(i, actions, additions, characters);

                if (Math.random() < .4)
                    act.addClarify(Utils.randomClarify(additions, characters));

                actions.add(act);
            }

            for (Person p : characters) {
                if (Math.random() < .5)
                    p.addClarify(Utils.randomClarify(additions, characters));

                if (Math.random() < .5)
                    p.addSubAction(Utils.randomChoice(actions));
            }

            int actionCount = new Random().nextInt(7, 10 + 1);
            for (int i = 0; i < actionCount; i++) {
                Utils.randomChoice(characters).performNormal(Utils.randomChoice(actions));
            }

        }).randomness(false).build().run();
    }
}