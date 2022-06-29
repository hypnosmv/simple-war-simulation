package types;

import java.util.ArrayList;

public class Map {

    // Map settings
    private static int sizeX = 100;
    private static int sizeY = 100;
    private boolean oneTeamStanding = false;
    private int iterations = 0;

    // Entities array
    private ArrayList<Entity> entities;

    // Constructor
    public Map (int sizeX, int sizeY, ArrayList<Entity> entities) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.entities = entities;
    }

    public static int getSizeX () {
        return sizeX;
    }

    public static int getSizeY () {
        return sizeY;
    }

    // Dealing damage (each unit deals damage to the unit closest to it)
    private void closestIndexDmg () {

        // Loop through the array
        for (int i = 0; i < entities.size(); i++) {

            float closestDist = sizeX + sizeY;
            int closestIndex = -1;

            // Find the closest one
            for  (int j = 0; j < entities.size(); j++) {
                if (entities.get(i).getTeam() != entities.get(j).getTeam()) {
                    float dist = entities.get(i).getDistTo(entities.get(j).getX(), entities.get(j).getY());
                    if (dist < closestDist && dist <= entities.get(i).getRange()) {
                        closestDist = dist;
                        closestIndex = j;
                    }
                }
            }

            // Finally, deal damage
            try {
                entities.get(closestIndex).takeDamage(entities.get(i).getDamage());
            } catch (IndexOutOfBoundsException e) { }

        }
    }

    // Main method
    public void run() {
        while(!oneTeamStanding) {

            // Checking if there is only one team left
            int lastTeam = entities.get(0).getTeam();
            oneTeamStanding = true;
            for (int i = 1; i < entities.size(); i++)
            {
                if (lastTeam != entities.get(i).getTeam()) {
                    oneTeamStanding = false;
                    break;
                }
            }

            // Removing dead entities
            for (int i = 0; i < entities.size(); i++) {
                if (entities.get(i).die()) entities.remove(i);
            }

            // Display final message or iterate further
            if (oneTeamStanding)
            {
                if (entities.size() == 0) {
                    System.out.println("\nNo Team has won in " + iterations + " iterations");
                }
                else {
                    System.out.println("\nTeam number " + lastTeam + " has won in " + iterations + " iterations");
                }

                for (Entity i : entities) {
                    String classString = String.valueOf(i.getClass());
                    System.out.println("Team: " + i.getTeam() + " - Class: " + classString.substring(12) + " - Health: " + i.getHealth());
                }
            }
            else {
                // Dealing damage
                closestIndexDmg();

                // Special Ability
                for (Entity i : entities) {
                    i.specialAbility();
                }

                // Moving the entities
                for (Entity i : entities) {
                    i.move();
                }
            }

            iterations++;
        }
    }
}
