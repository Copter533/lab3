package scenario;
// Он бросился к двери и стал изо всех сил колотить в нее кулаками,
// пока ему не открыли Лимончики,
// сторожившие тюрьму.

import actions.*;
import characters.He;
import characters.Lemons;
import characters.Person;
import components.Addition;

public class Main {
    public static void main(String[] args) {
        new AboutLemonsAndDoor().begin();
    }
}

//// Объекты ситуации
//Person he = new He();
//Person lemons = new Lemons();
//
//Addition door = new Addition("дверь");
//Addition jail = new Addition("тюрьма");
//
//RushTo rush_to = new RushTo(door);
//Guard guard = new Guard(jail);
//
//Banging banging = new Banging(door);
//        banging.setPrefix("стал изо всех сил");
//        banging.setSuffix("в неё кулаками");
//        banging.setOmitted(true);
//
//Open open = new Open(door);
//open.setPrefix("пока ему не");
//        open.setOmitted(true);
//
//        // Сама ситуация
//        he.perform(false, rush_to, banging);
//
//        lemons.addSubAction(guard);
//        lemons.perform(true, open);