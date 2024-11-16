package characters;

import components.Gender;
import components.HaveClarify;

public class PrinceLemon extends Person implements HaveClarify {
    public PrinceLemon() {
        super(Gender.MALE, "Принц Лемон");
    }
}