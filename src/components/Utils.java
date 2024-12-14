package components;

import actions.*;
import characters.Person;

import java.util.List;
import java.util.Random;

public interface Utils {
     static <T> T randomChoice(List<T> list) {
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }

    static Action randomAction(int index, List<Action> actions, List<Addition> additions, List<Person> characters) {
        switch (index) {
            case 0: return new Achieve(randomChoice(additions));
            case 1: return new Banging(randomChoice(additions));
            case 2: return new GetTo(randomChoice(additions));
            case 3: return new GetWhat(randomChoice(additions));
            case 4: return new GoTo(randomChoice(additions));
            case 5: return new Guard(randomChoice(additions));
            case 6: return new Open(randomChoice(additions));
            case 7: return new RushTo(randomChoice(additions));

            case 8: return new Execute(randomChoice(characters));
            case 9: return new TellTo(randomChoice(additions), randomChoice(characters));

            default:
                int orderCount = new Random().nextInt(4) + 1;
                Action[] randomOrders = new Action[orderCount];
                for (int i = 0; i < orderCount; i++) {
                    randomOrders[i] = randomChoice(actions);
                }
                return new Ordered(randomChoice(characters), randomOrders);
        }
    }

    static Clarify randomClarify(List<Addition> additions, List<Person> characters) {
        return switch (new Random().nextInt(0, 7)) {
            case 0 -> new NextMorning();
            case 1 -> new Satisfied();
            case 2 -> new WithAllMight();
            case 3 -> new WithOwnFists();
            case 4 -> new KnewFrom(randomChoice(characters));
            case 5 -> new Owner(randomChoice(characters));
            case 6 -> new RightAfter(randomChoice(additions));
            default -> throw new RuntimeException();
        };
    }
}
