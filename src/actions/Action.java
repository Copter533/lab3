package actions;

import characters.Person;

public class Action {
    protected final String desc;
    protected String prefix = "";
    protected String suffix = "";

    public Action(String desc) {
        this.desc = desc;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFullName() {
        if (this.prefix.isBlank() && this.suffix.isBlank())
            return this.desc;
        if (this.prefix.isBlank())
            return this.desc + " " + this.suffix;
        if (this.suffix.isBlank())
            return this.prefix + " " + this.desc;
        return this.prefix + " " + this.desc + " " + this.suffix;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
