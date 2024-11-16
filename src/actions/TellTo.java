package actions;

import characters.Person;
import components.Addition;

public class TellTo extends Action {
    public TellTo(Addition add, Person target) {
        super("рассказал");
        super.additions.add(add);
        super.additions.add(target.toAddition());
    }
}
