package actions;

import components.Addition;
import components.Clarify;
import components.HaveAddition;
import components.HaveClarify;

import java.util.ArrayList;
import java.util.List;

public class Action implements HaveClarify, HaveAddition {
    protected final String desc;
    protected String prefix = "";
    protected String suffix = "";

    protected final ArrayList<Addition> additions = new ArrayList<>();
    protected final ArrayList<Clarify>  clarifies = new ArrayList<>();
    protected boolean omitted = false;

    public Action(String desc, Addition... additions) {
        this.desc = desc;
        this.additions.addAll(List.of(additions));
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private String getSurroundedDesc() {
        if (this.prefix.isBlank() && this.suffix.isBlank())
            return this.desc;
        if (this.prefix.isBlank())
            return this.desc + " " + this.suffix;
        if (this.suffix.isBlank())
            return this.prefix + " " + this.desc;
        return this.prefix + " " + this.desc + " " + this.suffix;
    }

    public String getFullName() {
        if (additions.isEmpty() && clarifies.isEmpty())
            return getSurroundedDesc();

        if (additions.isEmpty())
            return getSurroundedDesc() + " " + HaveClarify.getClarifiesString(clarifies);

        if (clarifies.isEmpty())
            return getSurroundedDesc() + " " + HaveAddition.getAdditionsString(additions);

        return getSurroundedDesc()
                + " " + HaveAddition.getAdditionsString(additions)
                + " " + HaveClarify.getClarifiesString(clarifies);
    }

    public void setOmitted(boolean omitted) {
        this.omitted = omitted;
    }

    public boolean isOmitted() {
        return omitted;
    }

    @Override
    public String toString() {
        if (this.omitted) return getSurroundedDesc();
        return getFullName();
    }

    public Addition toAddition() {
        return new Addition(toString());
    }

    @Override
    public void addClarify(Clarify clarify) {
        clarifies.add(clarify);
    }

    public void addAddition(Addition add) {
        additions.add(add);
    }
}
