package actions;

import characters.Person;

public class Ordered extends Action {
    public Ordered(Person who, Action... orders) {
        super("приказал");
        addAddition(who.toAddition());
        for (Action order : orders)
            addAddition(order.toAddition());
    }
}
