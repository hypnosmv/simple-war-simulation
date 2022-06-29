package types;

public class Tank extends Entity {

    // Variables required for the special ability
    private int baseDamage = 0;
    private float baseRange = 0;
    private int iteration = 0;

    // Constructor
    public Tank(int team, int health, int damage, float moveRange, float range, float x, float y) {
        super(team, health, damage, moveRange, range, x, y);
        baseDamage = this.damage;
        baseRange = this.range;
    }

    // Special ability unique to the class
    @Override
    public void specialAbility () {

        // Every 50th iteration apply the special ability
        if (iteration == 49)
        {
            damage *= 2;
            range *= 3;

            iteration = 0;
        }
        else if (iteration == 0) {
            damage = baseDamage;
            range = baseRange;
        }

        iteration++;

    }
}

