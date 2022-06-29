package types;

import java.util.Random;

public class Soldier extends Entity {

    // Constructor
    public Soldier(int team, int health, int damage, float moveRange, float range, float x, float y) {
        super(team, health, damage, moveRange, range, x, y);
    }

    // Special ability unique to the class
    @Override
    public void specialAbility () {

        // 10% chance
        Random random = new Random();
        int chance = random.nextInt(10);

        // Increasing health by 2%
        if (chance == 0) {
            health *= 1.02;
        }

    }
}
