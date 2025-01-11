package characters;

import actions.Action;
import actions.ActionModifier;
import components.*;
import scenario.Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements HaveClarify {
    private final Gender gender;
    private final String name;

    private final ArrayList<Action> subActions = new ArrayList<>();
    private final ArrayList<Clarify> clarifies = new ArrayList<>();

    public Person(Gender gender) {
        this.gender = Gender.random(gender);
        this.name   = this.gender.who;
    }

    public Person(Gender gender, String name) {
        this.gender = Gender.random(gender);
        this.name   = name;
    }

    public static Person createInstance(Class<? extends Person> cls) {
        try {
            return cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании персонажа: " + cls.getSimpleName(), e);
        }
    }

    public void performNormal(Action... actions) {
        try {
            executeActions(ActionModifier.NORMAL, actions);
        } catch (TooLazyException ex) {
            System.out.printf("%s ничего не сделал\n", this);
        }
    }

    public void performReversed(Action... actions) {
        try {
            executeActions(ActionModifier.REVERSED, actions);
        } catch (TooLazyException ex) {
            System.out.printf("не сделал ничего %s\n", this);
        }
    }

    public void performOn(Action... actions) {
        try {
            executeActions(ActionModifier.TARGETED, actions);
        } catch (TooLazyException ex) {
            System.out.printf("над %s ничего не сделали\n", this);
        }
    }

    private void executeActions(ActionModifier type, Action... actions) {
        ArrayList<Action> newActions;
        ActionModifier resultType = type;
        if (Scenario.isCurrentRandom) {
            if (Math.random() < .15) {
                resultType = ActionModifier.random(type);
            }
            newActions = new ArrayList<>();
            for (Action action : actions) {
                if (Math.random() < .05) continue;
                newActions.add(action);
            }
        } else {
            newActions = new ArrayList<>(List.of(actions));
        }

        if (newActions.isEmpty())
            throw new TooLazyException(this);

        switch (resultType) {
            case NORMAL:
                System.out.printf("%s %s\n", this, getConcatActions(newActions));
                break;
            case REVERSED:
                System.out.printf("%s %s\n", getConcatActions(newActions), this);
                break;
            case TARGETED:
                System.out.printf("%s %s %s\n", this, gender.was, getConcatActions(newActions));
                break;
        }
    }

    public void addSubAction(Action action) {
        subActions.add(action);
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
        for (int i = 0; i < subActions.size(); i++) {
            result.append(", ");
            if (i == 0) result.append(gender.that).append(" ");
            result.append(subActions.get(i));
        }
        return result.toString();
    }

    public Addition toAddition() {
        return new Addition(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person p)
            return
                    p.name.equals(name) &&
                    p.gender.equals(gender) &&
                    p.clarifies.equals(clarifies) &&
                    p.subActions.equals(subActions);

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, name, clarifies, subActions);
    }
}