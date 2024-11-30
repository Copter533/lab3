package components;

import characters.Person;

public class NoStateException extends Exception {
  private final Person who;

  public NoStateException(Person who) {
        this.who = who;
    }

  @Override
  public String getMessage() {
    return who.toString() + " не находится ни в каком состоянии!";
  }
}
