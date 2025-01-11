package characters;

import components.Gender;

public class Prince extends Person {
    public Prince() {
        super(Gender.MALE, "принц");
    }

    public static void main(String[] args) {
        var p1 = new Prince();
        var p2 = new Prince();

        System.out.println(p1.equals(p2));
    }
}