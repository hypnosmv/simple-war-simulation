package types;
import java.util.Random;

public abstract class Entity {

    // Movement
    private static final float PI = 3.14159f;

    // Basic stats
    private int team = 0;
    protected int health = 0;
    protected int damage;

    // Advanced stats
    private float moveRange;
    protected float range;

    // Position
    private float x = 0.0f;
    private float y = 0.0f;

    Entity (int team, int health, int damage, float moveRange, float range, float x, float y) {
        this.team = team;
        this.health = health;
        this.damage = damage;
        this.moveRange = moveRange;
        this.range = range;
        this.x = x;
        this.y = y;
    }

    public int getTeam () {
        return this.team;
    }

    public int getHealth () {
        return this.health;
    }

    // Kills the entity
    public boolean die () {
        if (this.health <= 0) return true;
        else return false;
    }

    // Deals damage to the entity
    protected void takeDamage (int damage) {
        this.health -= damage;
    }

    public int getDamage () {
        return damage;
    }

    public void move() {

        // Random angle (counterclockwise)
        Random random = new Random();
        float angle = random.nextFloat(2*PI);

        // Initialization of matrices (the rotation matrix, the point (0, range), the output matrix)
        double[][] rotationMatrix = {   {Math.cos((double)angle), -Math.sin((double)angle)},
                                        {Math.sin((double)angle), Math.cos((double)angle)}   };
        float[] point = {0, this.moveRange};
        float[] moveVector = new float[2];

        // Multiplication of the matrices
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++)
                moveVector[i] += rotationMatrix[i][j] * point[j];
        }

        // Moving the entity
        this.x += moveVector[0];
        this.y += moveVector[1];

        if (this.x < 0.0f) this.x = 0.0f;
        else if (this.x > Map.getSizeX()) this.x = Map.getSizeX();
        if (this.y < 0.0f) this.y = 0.0f;
        else if (this.y > Map.getSizeY()) this.y = Map.getSizeY();
    }

    public float getRange () {
        return this.range;
    }

    public float getX () {
        return this.x;
    }

    public float getY () {
        return this.y;
    }

    public float getDistTo (float x, float y)
    {
        return (float)Math.sqrt((this.y - y) * (this.y - y) + (this.x - x) * (this.x - x));
    }

    public abstract void specialAbility ();
}
