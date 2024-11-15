package characters;

import actions.Action;
import actions.Open;
import actions.RushTo;
import utils.Gender;

import java.util.ArrayList;

public class Person {
    private final Gender gender;
    private final String name;
    private final ArrayList<Action> sub_actions = new ArrayList<>();

    public Person(Gender gender) {
        this.gender = gender;
        this.name   = gender.who;
    }

    public Person(Gender gender, String name) {
        this.gender = gender;
        this.name   = name;
    }

    public void perform(boolean reversed, Action... actions) {
        if (reversed)
            System.out.printf("%s %s\n", getConcatActions(actions), this);
        else
            System.out.printf("%s %s\n", this, getConcatActions(actions));
    }

    public void addSubAction(Action action) {
        sub_actions.add(action);
    }

    public String getConcatActions(Action... actions) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < actions.length; i++) {
            if (i != 0) result.append(" и ");
            result.append(actions[i]);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name);
        for (int i = 0; i < sub_actions.size(); i++) {
            result.append(", ");
            if (i == 0) result.append(gender.that).append(" ");
            result.append(sub_actions.get(i));
        }
        return result.toString();
    }
}