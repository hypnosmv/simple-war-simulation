import types.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Entity> entities = new ArrayList<Entity>();

        // Team 1
        entities.add(new Soldier(1, 90, 20, 2.0f, 10.0f, 0.0f, 0.0f));
        entities.add(new Soldier(1, 80, 30, 6.5f, 5.0f, 0.0f, 0.0f));
        entities.add(new Soldier(1, 70, 20, 5.0f, 6.0f, 0.0f, 0.0f));
        entities.add(new Soldier(1, 140, 50, 3.0f, 7.5f, 0.0f, 0.0f));
        entities.add(new Soldier(1, 140, 50, 3.0f, 7.5f, 0.0f, 0.0f));
        entities.add(new Tank(1, 500, 30, 1.0f, 20.0f, 0.0f, 0.0f));
        entities.add(new Tank(1, 300, 55, 2.0f, 10.0f, 0.0f, 0.0f));
        entities.add(new Tank(1, 230, 40, 1.5f, 25.0f, 0.0f, 0.0f));

        // Team 2
        entities.add(new Soldier(2, 80, 50, 6.0f, 4.0f, 50.0f, 50.0f));
        entities.add(new Soldier(2, 150, 20, 10.0f, 12.0f, 50.0f, 50.0f));
        entities.add(new Soldier(2, 150, 20, 10.0f, 15.0f, 50.0f, 50.0f));
        entities.add(new Soldier(2, 90, 40, 9.0f, 6.0f, 50.0f, 50.0f));
        entities.add(new Soldier(2, 100, 50, 7.0f, 8.5f, 50.0f, 50.0f));
        entities.add(new Tank(2, 400, 30, 2.0f, 15.0f, 50.0f, 50.0f));
        entities.add(new Tank(2, 800, 30, 2.0f, 10.0f, 50.0f, 50.0f));
        entities.add(new Tank(2, 350, 30, 2.0f, 35.0f, 50.0f, 50.0f));
        entities.add(new Tank(2, 250, 80, 2.0f, 35.0f, 50.0f, 50.0f));

        // Team 3
        entities.add(new Soldier(3, 150, 10, 5.0f, 20.0f, 100.0f, 100.0f));
        entities.add(new Soldier(3, 110, 30, 6.0f, 5.0f, 100.0f, 100.0f));
        entities.add(new Soldier(3, 70, 10, 5.0f, 7.0f, 100.0f, 100.0f));
        entities.add(new Soldier(3, 10, 10, 8.0f, 4.0f, 100.0f, 100.0f));
        entities.add(new Tank(3, 400, 20, 2.0f, 30.0f, 100.0f, 100.0f));
        entities.add(new Tank(3, 200, 40, 1.0f, 30.0f, 100.0f, 100.0f));

        // Creating a map
        Map map = new Map(1000, 1000, entities);

        // Running the battle
        map.run();

    }
}