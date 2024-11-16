package characters;

import actions.Action;
import components.Addition;
import components.Clarify;
import components.Gender;
import components.HaveClarify;

import java.util.ArrayList;

public class Person implements HaveClarify {
    private final Gender gender;
    private final String name;

    private final ArrayList<Action> sub_actions = new ArrayList<>();
    private final ArrayList<Clarify> clarifies = new ArrayList<>();

    public Person(Gender gender) {
        this.gender = gender;
        this.name   = gender.who;
    }

    public Person(Gender gender, String name) {
        this.gender = gender;
        this.name   = name;
    }

    public void perform(Action... actions) {
        System.out.printf("%s %s\n", this, getConcatActions(actions));
    }

    public void perform_reversed(Action... actions) {
        System.out.printf("%s %s\n", getConcatActions(actions), this);
    }

    public void perform_on(Action... actions) {
        System.out.printf("%s %s %s\n", this, gender.was, getConcatActions(actions));
    }

    public void addSubAction(Action action) {
        sub_actions.add(action);
    }

    @Override
    public void addClarify(Clarify clarify) {
        clarifies.add(clarify);
    }

    public void getState() {
        System.out.printf("%s %s %s\n", this, gender.was, HaveClarify.getClarifiesString(clarifies));
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

    public Addition toAddition() {
        return new Addition(name);
    }
}