package components;

import characters.Person;

public class TooLazyException extends RuntimeException {
  private final Person who;

  public TooLazyException(Person who) {
        this.who = who;
    }

  @Override
  public String getMessage() {
    return who.toString() + " оказаля слишком ленивым и не выполнил ни одного действия!";
  }
}
