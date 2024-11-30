package characters;

import actions.Action;
import components.*;

import java.util.ArrayList;

public class Person implements HaveClarify {
    private final Gender gender;
    private final String name;

    private final ArrayList<Action> sub_actions = new ArrayList<>();
    private final ArrayList<Clarify> clarifies = new ArrayList<>();

    public Person(Gender gender) {
        this.gender = Gender.random(gender);
        this.name   = this.gender.who;
    }

    public Person(Gender gender, String name) {
        this.gender = Gender.random(gender);
        this.name   = name;
    }

    public void perform(Action... actions) {
        executeActions(0, actions);
    }

    public void performReversed(Action... actions) {
        executeActions(1, actions);
    }

    public void performOn(Action... actions) {
        executeActions(2, actions);
    }

    private void executeActions(int type, Action... actions) {
        try {
            int result_type = type;
            if (Math.random() < .05) {
                result_type = (int) (Math.random() * 2);
                if (result_type == type) result_type += 1;
            }
            ArrayList<Action> new_actions = new ArrayList<>();
            for (Action action : actions) {
                if (Math.random() < .05) continue;
                new_actions.add(action);
            }

            if (new_actions.isEmpty())
                throw new TooLazyException(this);

            switch (result_type) {
                case 0:
                    System.out.printf("%s %s\n", this, getConcatActions(new_actions));
                    break;
                case 1:
                    System.out.printf("%s %s\n", getConcatActions(new_actions), this);
                    break;
                case 2:
                    System.out.printf("%s %s %s\n", this, gender.was, getConcatActions(new_actions));
                    break;
            }
        } catch (TooLazyException ex) {
            System.out.printf("%s ничего не сделал\n", this);
        }
    }

    public void addSubAction(Action action) {
        sub_actions.add(action);
    }

    @Override
    public void addClarify(Clarify clarify) {
        clarifies.add(clarify);
    }

    public void getState() throws NoStateException {
        if (clarifies.isEmpty()) throw new NoStateException(this);
        System.out.printf("%s %s %s\n", this, gender.was, HaveClarify.getClarifiesString(clarifies));
    }

    public String getConcatActions(ArrayList<Action> actions) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < actions.size(); i++) {
            if (i != 0) result.append(" и ");
            result.append(actions.get(i));
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