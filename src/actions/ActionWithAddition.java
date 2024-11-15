package actions;

import components.Addition;

public class ActionWithAddition extends Action {
    protected final Addition addition;
    protected boolean omitted = false;

    public ActionWithAddition(String desc, Addition addition) {
        super(desc);
        this.addition = addition;
    }

    public void setOmitted(boolean omitted) {
        this.omitted = omitted;
    }

    public boolean isOmitted() {
        return omitted;
    }

    @Override
    public String getFullName() {
        if (this.omitted) return super.getFullName();
        return super.getFullName() + " " + this.addition.name();
    }
}
