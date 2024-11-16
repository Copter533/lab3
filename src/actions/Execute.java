package actions;

import characters.Person;
import components.Addition;
import components.HaveAddition;

public class Execute extends Action {
    public Execute(Person victim) {
        super("казнить", victim.toAddition());
    }

    @Override
    public Addition toAddition() {
        return new Addition("казнь " + HaveAddition.getAdditionsString(additions));
    }
}
